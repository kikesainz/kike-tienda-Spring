package com.kike.tienda.controllers.rest;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kike.tienda.dtos.CategoriasDTO;
import com.kike.tienda.entities.CategoriaEntity;
import com.kike.tienda.negocio.CategoriasService;
import com.kike.tienda.repositories.CategoriasRepository;

@RestController
@RequestMapping("/v1")
public class CategoriasControllerRest {

	@Autowired
	CategoriasService categoriasServicio;
	@Autowired
	CategoriasRepository categoriaRepository;
	
	@GetMapping("/categorias")
	public Iterable<CategoriaEntity> obtenerTodasCategorias(){
		Iterable<CategoriaEntity> categorias = categoriaRepository.findAll();
		
		return categorias;
	}
	
	@GetMapping("/categorias/{id}")
	public ResponseEntity<CategoriaEntity>obtenerCategoriasPorId(@PathVariable("id") Integer id){
		
		String idBuscar = id+"";
		CategoriaEntity categoria = categoriaRepository.findById(idBuscar).get();
		
		return new ResponseEntity<>(categoria, HttpStatus.OK);
	}
	
	@GetMapping(value="/categorias", params = {"id", "nombre", "descripcion", "activo"})
	public List<CategoriasDTO>buscarCategoriasConFiltros(@RequestParam(value = "id", required =false) String id,
			@RequestParam(value= "nombre", required=false) String nombre,
			@RequestParam(value= "descripcion", required=false) String descripcion,
			@RequestParam(value= "activo", required=false) Integer activo){
		List<CategoriasDTO> c = categoriaRepository.buscarCategoriasporIDyNombre(id, nombre, descripcion, activo);
		
		return c;
	}
	
	@PostMapping("/categorias")
	public ResponseEntity insertarCategorias(@RequestBody CategoriaEntity categoria) throws ClassNotFoundException, SQLException, NamingException {
		
		Integer resultado = categoriasServicio.insertarCategorias(categoria.getNombre(), categoria.getDescripcion(), categoria.getActivo().toString());
		return new ResponseEntity<>("Categoria insertada correctamente", HttpStatus.OK);
	}
	
	@PutMapping("/categorias")
	public ResponseEntity actualizarCategorias(@RequestBody CategoriaEntity categoria) {
		categoriaRepository.save(categoria);
		
		return new ResponseEntity<>("Categoría actualizada correctamente", HttpStatus.OK);
	}
	
	@DeleteMapping("/categorias")
	public ResponseEntity borrarCategorias(@RequestBody CategoriaEntity categoria) {
		
		
		categoria.setActivo(0);
		categoriaRepository.save(categoria);
		
		return new ResponseEntity<>("Categoría borrada correctamente", HttpStatus.OK);
	}
}
