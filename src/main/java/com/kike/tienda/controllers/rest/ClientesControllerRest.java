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
import com.kike.tienda.dtos.ClientesDTO;
import com.kike.tienda.entities.CategoriaEntity;
import com.kike.tienda.entities.ClienteEntity;
import com.kike.tienda.negocio.ClientesService;
import com.kike.tienda.repositories.ClientesRepository;

@RestController
@RequestMapping("/v1")
public class ClientesControllerRest {

	@Autowired
	ClientesRepository clientesRepository;
	@Autowired
	ClientesService clientesServicio;
	
	@GetMapping("/clientes")
	public Iterable<ClienteEntity> obtenerTodssClientes(){
		Iterable<ClienteEntity> clientes = clientesRepository.findAll();
		
		return clientes;
	}
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<ClienteEntity>obtenerClientesPorId(@PathVariable("id") Integer id){
		
		String idBuscar = id+"";
		ClienteEntity cliente = clientesRepository.findById(idBuscar).get();
		
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	@GetMapping(value="/clientes", params = {"id", "nombre", "correoElectronico", "poblacion", "activo"})
	public List<ClientesDTO>buscarCategoriasConFiltros(@RequestParam(value = "id", required =false) String id,
			@RequestParam(value= "nombre", required=false) String nombre,
			@RequestParam(value= "correoElectronico", required=false) String correoElectronico,
			@RequestParam(value= "poblacion", required=false) String poblacion,
			@RequestParam(value= "activo", required=false) Integer activo){
		List<ClientesDTO> c = clientesRepository.buscarClientesporIdNombre(id, nombre, correoElectronico, poblacion, activo);
		
		return c;
	}
	
	@PostMapping("/clientes")
	public ResponseEntity insertarClientes(@RequestBody ClienteEntity cliente) throws ClassNotFoundException, SQLException, NamingException {
		

		
		
		Integer resultado = clientesServicio.insertarClientes(cliente.getNombre(), cliente.getCorreoElectronico(), cliente.getPoblacion().getId(), cliente.getActivo().toString());
		return new ResponseEntity<>("Cliente insertado correctamente", HttpStatus.OK);
	}
	
	@PutMapping("/clientes")
	public ResponseEntity actualizarClientes(@RequestBody ClienteEntity cliente) {
		clientesRepository.save(cliente);
		
		return new ResponseEntity<>("Cliente actualizado correctamente", HttpStatus.OK);
	}
	
	@DeleteMapping("/clientes")
	public ResponseEntity borrarClientes(@RequestBody ClienteEntity cliente) {
		
		
		cliente.setActivo(0);
		clientesRepository.save(cliente);
		
		return new ResponseEntity<>("Cliente borrado correctamente", HttpStatus.OK);
	}
}
