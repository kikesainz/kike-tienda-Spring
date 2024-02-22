package com.kike.tienda.controllers.rest;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kike.tienda.dtos.CategoriasDTO;
import com.kike.tienda.dtos.ProveedoresDTO;
import com.kike.tienda.entities.CategoriaEntity;
import com.kike.tienda.entities.ProveedorEntity;
import com.kike.tienda.negocio.ProveedoresService;
import com.kike.tienda.repositories.ProveedoresRepository;

@RestController
@RequestMapping("/v1")
public class ProveedoresControllerRest {

	
	@Autowired
	ProveedoresRepository proveedoresRepository;
	@Autowired
	ProveedoresService proveedorServicio;
	
	@GetMapping("/proveedores")
	public Iterable<ProveedorEntity> obtenerTodosProveedores(){
		Iterable<ProveedorEntity> proveedores = proveedoresRepository.findAll();
		
		return proveedores;
	}
	
	@GetMapping("/proveedores/{id}")
	public ResponseEntity<ProveedorEntity>obtenerProveedorPorId(@PathVariable("id") Integer id){
		
		String idBuscar = id+"";
		ProveedorEntity proveedores = proveedoresRepository.findById(idBuscar).get();
		
		return new ResponseEntity<>(proveedores, HttpStatus.OK);
	}
	
	@GetMapping(value="/proveedores", params = {"id", "nombre", "contacto", "telefono", "correoElectronico", "direccion", "activo"})
	public List<ProveedoresDTO>buscarProveedoresConFiltros(@RequestParam(value = "id", required =false) String id,
			@RequestParam(value= "nombre", required=false) String nombre,
			@RequestParam(value= "contacto", required=false) String contacto,
			@RequestParam(value= "telefono", required=false) String telefono,
			@RequestParam(value= "correoElectronico", required=false) String correoElectronico,
			@RequestParam(value= "direccion", required=false) String direccion,
			@RequestParam(value= "activo", required=false) Integer activo){
		List<ProveedoresDTO> proveedores = proveedoresRepository.buscarProveedoresPorIdyNombre(id, nombre, contacto, telefono, correoElectronico, direccion, activo);
		
		return proveedores;
	}
	
	@PostMapping("/proveedores")
	public ResponseEntity insertarProveedores(@RequestBody ProveedorEntity proveedor) throws ClassNotFoundException, SQLException, NamingException {

		
		Integer resultado = proveedorServicio.insertarProveedor(proveedor.getId(), proveedor.getNombre(), proveedor.getContacto(), proveedor.getTelefono(), proveedor.getCorreoElectronico(), proveedor.getDireccion(), proveedor.getActivo().toString());
		return new ResponseEntity<>("Proveedor insertado correctamente", HttpStatus.OK);
	}
	
	@PutMapping("/proveedores")
	public ResponseEntity actualizarCategorias(@RequestBody ProveedorEntity proveedor) {
		proveedoresRepository.save(proveedor);
		
		return new ResponseEntity<>("Proveedor actualizado correctamente", HttpStatus.OK);
	}
}
