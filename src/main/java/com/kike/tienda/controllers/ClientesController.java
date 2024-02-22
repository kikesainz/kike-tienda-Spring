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

import com.kike.tienda.dao.IComboDAO;
import com.kike.tienda.dtos.ClientesDTO;
import com.kike.tienda.dtos.ComboDTO;
import com.kike.tienda.negocio.IClientesService;

@Controller

public class ClientesController {

	@Autowired
	IClientesService clientesServicio;
	@Autowired
	IComboDAO combosDAO;

	@GetMapping("/clientes/obtenerclientes")
	public String clientesController(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {

		
		List<ComboDTO> listaPoblaciones = combosDAO.recuperarListaPoblacion();
		model.addAttribute("combosPoblacion", listaPoblaciones);
		return "listadoClientes";
	}

	@PostMapping("/clientes/listarclientes")
	public String buscarClientes(@RequestParam("idClientes") String idCliente, @RequestParam("nombre") String nombre,
			@RequestParam("correoElectronico") String correoElectronico,
			@RequestParam("idPoblacion") String idPoblacion, @RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		activo = (activo != null) ? "1" : "0";

		List<ComboDTO> listaPoblaciones = combosDAO.recuperarListaPoblacion();
		model.addAttribute("combosPoblacion", listaPoblaciones);
		
		List<ClientesDTO> listaClientes = clientesServicio.buscarClientes(idCliente, nombre, correoElectronico,
				idPoblacion, activo);
		model.addAttribute("listaClientes", listaClientes);
		return "listadoClientes";
	}

	@GetMapping("/clientes/insertarclientes")
	public String getFormularioInsertarClientes(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaPoblaciones = combosDAO.recuperarListaPoblacion();
		model.addAttribute("combosPoblacion", listaPoblaciones);
		return "insertarClientes";
	}

	@PostMapping("/clientes/insertarclientes")
	public String insertarClientes(@RequestParam("nombre") String nombre,
			@RequestParam("correoElectronico") String correoElectronico,
			@RequestParam("idPoblacion") String idPoblacion, @RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		activo = (activo != null) ? "1" : "0";
		Integer resultado = clientesServicio.insertarClientes(nombre, correoElectronico, idPoblacion, activo);
		model.addAttribute("resultado", resultado);
		List<ComboDTO> listaPoblaciones = combosDAO.recuperarListaPoblacion();
		model.addAttribute("combosPoblacion", listaPoblaciones);
		return "insertarClientes";
	}

	@GetMapping("/clientes/formularioactualizarclientes")
	public String getFormularioactualizarClientes(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaPoblaciones = combosDAO.recuperarListaPoblacion();
		model.addAttribute("combosPoblacion", listaPoblaciones);
		return "actualizarClientes";
	}

	@PostMapping("/clientes/formularioactualizarclientes")
	public String actualizarClientes(@RequestParam("idClientes") String idCliente,
			@RequestParam("nombre") String nombre, @RequestParam("correoElectronico") String correoElectronico,
			@RequestParam("idPoblacion") String idPoblacion, @RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";
		List<ClientesDTO> listaClientes = clientesServicio.buscarClientes(idCliente, nombre, correoElectronico, idPoblacion, activo);
		model.addAttribute("listaClientes", listaClientes);
		List<ComboDTO> listaPoblaciones = combosDAO.recuperarListaPoblacion();
		model.addAttribute("combosPoblacion", listaPoblaciones);
		
		return "actualizarClientes";
	}
	@PostMapping("/clientes/actualizarclientes")
	public String actualizarCliente(@RequestParam("idClientes") String idCliente, @RequestParam("nombre") String nombre,
			@RequestParam("correoElectronico") String correoElectronico,
			@RequestParam("idPoblacion") String idPoblacion, @RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		activo = (activo != null) ? "1" : "0";
		Integer resultado = clientesServicio.actualizarClientes(idCliente, nombre, correoElectronico, idPoblacion, activo);
		
		List<ClientesDTO> listaClientes = clientesServicio.buscarClientes(idCliente, nombre, correoElectronico, idPoblacion, activo);
		model.addAttribute("listaClientes", listaClientes);
		
		List<ComboDTO> listaPoblaciones = combosDAO.recuperarListaPoblacion();
		model.addAttribute("combosPoblacion", listaPoblaciones);
		return "actualizarClientes";
	}
	
	@GetMapping("/clientes/formularioborrarclientes")
	public String getFormularioBorrarClientes(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaPoblaciones = combosDAO.recuperarListaPoblacion();
		model.addAttribute("combosPoblacion", listaPoblaciones);
		return "borrarClientes";
	}
	@PostMapping("/clientes/formularioborrarclientes")
	public String borrarClientes(@RequestParam("idClientes") String idCliente,
			@RequestParam("nombre") String nombre, @RequestParam("correoElectronico") String correoElectronico,
			@RequestParam("idPoblacion") String idPoblacion, @RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";
		
		List<ClientesDTO> listaClientes = clientesServicio.buscarClientes(idCliente, nombre, correoElectronico, idPoblacion, activo);
		model.addAttribute("listaClientes", listaClientes);
		
		return "borrarClientes";
	}
	@PostMapping("/clientes/borrarclientes")
	public String borrarCliente(@RequestParam("idClientes") String idCliente, @RequestParam("nombre") String nombre,
			@RequestParam("correoElectronico") String correoElectronico,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		
		clientesServicio.borrarClientes(idCliente);


		List<ComboDTO> listaPoblaciones = combosDAO.recuperarListaPoblacion();
		model.addAttribute("combosPoblacion", listaPoblaciones);
		
		return "borrarClientes";
	}
	
}
