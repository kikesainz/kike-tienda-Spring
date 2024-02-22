package com.kike.tienda.controllers.rest;

import java.util.List;

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

import com.kike.tienda.dtos.PeticionesDTO;
import com.kike.tienda.entities.PeticionesEntity;
import com.kike.tienda.repositories.PeticionesRepository;

@RestController
@RequestMapping("/v1")
public class PeticionesControllerRest {

	@Autowired
	PeticionesRepository peticionesRepository;
	
	@GetMapping("/peticiones")
	public Iterable<PeticionesEntity> obtenerTodasPeticiones(){
		Iterable<PeticionesEntity> peticiones = peticionesRepository.findAll();
		return peticiones;
	}
	@GetMapping("/peticiones/{id}")
	public ResponseEntity<PeticionesEntity>obtenerPeticionesPorId(@PathVariable("id") Integer id){
		String idBuscar = id.toString();
		PeticionesEntity peticiones = peticionesRepository.findById(idBuscar).get();
		return new ResponseEntity<>(peticiones, HttpStatus.OK);
	}
	@GetMapping(value="/peticiones", params = {"id", "cliente", "producto", "fecha", "cantidad"})
	public List<PeticionesDTO> buscarPeticionesConFiltros(@RequestParam(value = "id", required =false) String id,
			@RequestParam(value = "cliente", required =false) String cliente,
			@RequestParam(value = "producto", required =false) String producto,
			@RequestParam(value = "fecha", required =false) String fecha,
			@RequestParam(value = "cantidad", required =false) String cantidad){
		
		List<PeticionesDTO> listaPeticiones = peticionesRepository.buscarPeticionesporIdyNombre(id, cliente, producto, fecha, Integer.parseInt(cantidad), null);
		return listaPeticiones;
	}
	
	@PostMapping("/peticiones")
	public ResponseEntity insertarPeticiones(@RequestBody PeticionesEntity peticiones) {
		peticionesRepository.save(peticiones);
		return new ResponseEntity<>("Petición insertada correctamente", HttpStatus.OK);
	}
	
	@PutMapping("/peticiones")
	public ResponseEntity actualizarPeticiones(@RequestBody PeticionesEntity peticiones) {
		peticionesRepository.save(peticiones);
		return new ResponseEntity<>("Petición actualizada correctamente", HttpStatus.OK);
	}
	
	@DeleteMapping("/peticiones")
	public ResponseEntity borrarPeticiones(@RequestBody PeticionesEntity peticiones) {
		peticiones.setCantidad(0);
		peticionesRepository.save(peticiones);
		return new ResponseEntity<>("Petición borrada correctamente", HttpStatus.OK);
	}
}
