package com.kike.tienda.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kike.tienda.dtos.CategoriasDTO;
import com.kike.tienda.negocio.ICaregoriasService;


@Controller
@RequestMapping("/")	
public class CategoriasController {

	@Autowired
	ICaregoriasService categoriasServicio;
	
	@GetMapping("/obtenercategorias")
	public String categoriasController() {
		return "listadoCategorias";
	}
	
	@PostMapping("/obtenercategorias")
	public String buscarCategorias(@RequestParam("id") String id, @RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion, @RequestParam(value = "activo", required = false) String activo, ModelMap model) throws ClassNotFoundException, SQLException, NamingException{
		
		activo = (activo != null) ? "1" : "0";
		
		List<CategoriasDTO> listaCategorias = categoriasServicio.buscarCategorias(id, nombre, descripcion, activo);
		model.addAttribute("listaCategorias", listaCategorias);
		
		return "listadoCategorias";
	}
	
	@GetMapping("/insertarcategorias")
	public String getFormularioInsertarCategorias(ModelMap model) {
		return "insertarCategorias";
	}
	
	@PostMapping("/insertarcategorias")
	public String insertarCategorias(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion, @RequestParam(value = "activo", required = false) String activo, ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		activo = (activo != null) ? "1" : "0";
		Integer resultado = categoriasServicio.insertarCategorias(nombre, descripcion, activo);
		model.addAttribute("resultado", resultado);
		
		return "insertarCategorias";
	}
	
	@GetMapping("/formularioactualizarcategorias")
	public String getFormularioActualizarCategorias() {
		return "actualizarCategorias";
	}
	
	@PostMapping("/formularioactualizarcategorias")
	public String actualizarCategorias1(@RequestParam("id") String id, @RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion, @RequestParam(value = "activo", required = false) String activo, ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		activo = (activo != null) ? "1" : "0";
		List<CategoriasDTO> listaCategorias = categoriasServicio.buscarCategorias(id, nombre, descripcion, activo);
		model.addAttribute("listaCategorias", listaCategorias);
		
		return "actualizarCategorias";
	}
	
	@PostMapping("/actualizarcategorias")
	public String actualizarCategorias(@RequestParam("id") String id, @RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion, @RequestParam(value = "activo", required = false) String activo, ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		activo = (activo != null) ? "1" : "0";
		Integer resultado = categoriasServicio.actualizarCategorias(id, nombre, descripcion, activo);
		model.addAttribute("resultado", resultado);
		
		
		return "actualizarCategorias";
	}
	
	@GetMapping("/formularioborrarcategorias")
	public String formularioBorrarCategorias() {
		return "borrarCategorias";
	}
	
	@PostMapping("/formularioborrarcategorias")
	public String getFormularioBorrarCategorias(@RequestParam("id") String id, @RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion, @RequestParam(value = "activo", required = false) String activo, ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
	
		activo = (activo != null) ? "1" : "0";
		
		List<CategoriasDTO> listaCategorias = categoriasServicio.buscarCategorias(id, nombre, descripcion, activo);
		model.addAttribute("listaCategorias", listaCategorias);
		
		return "borrarCategorias";
	}
	
	@PostMapping("/borrarcategorias")
	public String borrarCategorias(@RequestParam("id") String id, @RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion, @RequestParam(value = "activo", required = false) String activo, ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
	
		categoriasServicio.borrarCategorias(id);
		
		return "borrarCategorias";
	}
}
