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
import com.kike.tienda.dtos.ProductosDTO;
import com.kike.tienda.entities.CategoriaEntity;
import com.kike.tienda.entities.ProductoEntity;
import com.kike.tienda.negocio.ProductosService;
import com.kike.tienda.repositories.ProductoRepository;

@RestController
@RequestMapping("/v1")
public class ProductosControllerRest {

	@Autowired
	ProductoRepository productosRepository;
	@Autowired
	ProductosService productosService;
	
	@GetMapping("/productos")
	public Iterable<ProductoEntity> obtenerTodosProductos(){
		Iterable<ProductoEntity> productos = productosRepository.findAll();
		
		return productos;
	}
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<ProductoEntity>obtenerProductosPorId(@PathVariable("id") Integer id){
		
		String idBuscar = id+"";
		ProductoEntity productos = productosRepository.findById(idBuscar).get();
		
		return new ResponseEntity<>(productos, HttpStatus.OK);
	}
	
	@GetMapping(value="/productos", params = {"id", "nombre", "descripcion", "precio", "cantidad", "categoria", "proveedor"})
	public List<ProductosDTO>buscarProductosConFiltros(@RequestParam(value = "id", required =false) String id,
			@RequestParam(value= "nombre", required=false) String nombre,
			@RequestParam(value= "descripcion", required=false) String descripcion,
			@RequestParam(value= "precio", required=false) Double precio,
			@RequestParam(value= "cantidad", required=false) Integer cantidad,
			@RequestParam(value= "categoria", required=false) String categoria,
			@RequestParam(value= "proveedor", required=false) String proveedor){
		List<ProductosDTO> productos = productosRepository.buscarProductosporIdyNombre(id, nombre, descripcion, precio, cantidad, categoria, proveedor);
		
		return productos;
	}
	
	@PostMapping("/productos")
	public ResponseEntity insertarProductos(@RequestBody ProductoEntity productos) throws ClassNotFoundException, SQLException, NamingException {
		

		Integer resultado = productosService.insertarProducto(productos.getNombre(), productos.getDescripcion(), productos.getPrecio(), productos.getCantidadEnStock(), productos.getCategoria().getId(),  productos.getProveedor().getId());
		return new ResponseEntity<>("Producto insertado correctamente", HttpStatus.OK);
	}
	
	@PutMapping("/productos")
	public ResponseEntity actualizarProductos(@RequestBody ProductoEntity productos) {
		productosRepository.save(productos);
		
		return new ResponseEntity<>("Producto actualizado correctamente", HttpStatus.OK);
	}
}
