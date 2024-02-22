package com.kike.tienda.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kike.tienda.dtos.ProveedoresDTO;
import com.kike.tienda.negocio.IProveedoresService;

@Controller
public class ProveedoresController {

	@Autowired
	IProveedoresService proveedoresServicio;
	
	@GetMapping("/proveedores/listarproveedores")
	public String proveedoresCController(ModelMap model)throws ClassNotFoundException, SQLException, NamingException {
	
		
		return "listadoProveedores";
	}
	@PostMapping("/proveedores/listarproveedores")
	public String buscarClientes(@RequestParam("idProveedor") String idProveedor,
			@RequestParam("nombre") String nombre,
			@RequestParam("contacto") String contacto,
			@RequestParam("telefono") String telefono,
			@RequestParam("correoElectronico") String correoElectronico,
			@RequestParam("direccion") String direccion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		
		activo = (activo != null) ? "1" : "0";

		List<ProveedoresDTO> listaProveedores = proveedoresServicio.buscarProveedor(idProveedor, nombre, contacto, telefono, correoElectronico, direccion, activo);
		model.addAttribute("listaProveedores", listaProveedores);
		
		return "listadoProveedores";
	}
	@GetMapping("/proveedores/insertarproveedores")
	public String getFormularioInsertarProveedores(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		return "insertarProveedores";
	}
	@PostMapping("/proveedores/insertarproveedores")
	public String insertarProveedor(@RequestParam("idProveedor") String idProveedor,
			@RequestParam("nombre") String nombre,
			@RequestParam("contacto") String contacto,
			@RequestParam("telefono") String telefono,
			@RequestParam("telefono") String correoElectronico,
			@RequestParam("direccion") String direccion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		
		activo = (activo != null) ? "1" : "0";
		Integer resultado = proveedoresServicio.insertarProveedor(idProveedor, nombre, contacto, telefono, correoElectronico, direccion, activo);
		model.addAttribute("resultado", resultado);
		return "insertarProveedores";
	}
	@GetMapping("/proveedores/formularioactualizarproveedores")
	public String getFormularioActualizarCategorias() {
		return "actualizarProveedores";
	}
	@PostMapping("/proveedores/formularioactualizarproveedores")
	public String actualizarProveedor(@RequestParam("idProveedor") String idProveedor,
			@RequestParam("nombre") String nombre,
			@RequestParam("contacto") String contacto,
			@RequestParam("telefono") String telefono,
			@RequestParam("telefono") String correoElectronico,
			@RequestParam("direccion") String direccion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		activo = (activo != null) ? "1" : "0";
		List<ProveedoresDTO> listaProveedores = proveedoresServicio.buscarProveedor(idProveedor, nombre, contacto, telefono, correoElectronico, direccion, activo);
		model.addAttribute("listaProveedores", listaProveedores);
		
		return "actualizarProveedores";
	}
	@PostMapping("/proveedores/actualizarproveedores")
	public String actualizarProveedores(@RequestParam("idProveedor") String idProveedor,
			@RequestParam("nombre") String nombre,
			@RequestParam("contacto") String contacto,
			@RequestParam("telefono") String telefono,
			@RequestParam("telefono") String correoElectronico,
			@RequestParam("direccion") String direccion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		
		activo = (activo != null) ? "1" : "0";
		Integer resultado = proveedoresServicio.actualizarProvedor(idProveedor, nombre, contacto, telefono, correoElectronico, direccion, activo);
		model.addAttribute("resultado", resultado);
		return "actualizarProveedores";
	}
}
