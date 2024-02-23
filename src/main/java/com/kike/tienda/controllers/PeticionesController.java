package com.kike.tienda.controllers;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kike.tienda.dao.IComboDAO;
import com.kike.tienda.dtos.ComboDTO;
import com.kike.tienda.dtos.PeticionesDTO;
import com.kike.tienda.negocio.IPeticionesService;

@Controller
public class PeticionesController {

	@Autowired
	IPeticionesService peticionesServicio;
	@Autowired
	IComboDAO combosDAO;
	
	@GetMapping("/peticiones/listarpeticiones")
	public String peticionesController(ModelMap model) throws ClassNotFoundException, SQLException, NamingException{
		
		List<ComboDTO> listaClientes = combosDAO.recuperarListaClientes();
		model.addAttribute("combosClientes", listaClientes);
		List<ComboDTO> listaProductos = combosDAO.recuperarListaProductos();
		model.addAttribute("combosProductos", listaProductos);
		List<ComboDTO> listaEstados = combosDAO.recuperarListaEstados();
		model.addAttribute("combosEstados", listaEstados);
		return "peticiones/listadoPeticiones";
	}
	@PostMapping("/peticiones/listarpeticiones")
	public String buscarPeticiones(@RequestParam("idPeticion") String idPeticion,
			@RequestParam("idCliente") String idCliente,
			@RequestParam("idProducto") String idProducto,
			@RequestParam("cantidad") String cantidad,
			@RequestParam("idEstado") String idEstado,
			@RequestParam("fechaPedido") String fechaPedido, ModelMap model
			)  throws ClassNotFoundException, SQLException, NamingException{
		
		if(fechaPedido.equals("")) {
			fechaPedido = "1971-01-01";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		if (fechaPedido == "") {
			fechaPedido = sdf.format(new Date());
		}
		
		List<ComboDTO> listaClientes = combosDAO.recuperarListaClientes();
		model.addAttribute("combosClientes", listaClientes);
		List<ComboDTO> listaProductos = combosDAO.recuperarListaProductos();
		model.addAttribute("combosProductos", listaProductos);
		List<ComboDTO> listaEstados = combosDAO.recuperarListaEstados();
		model.addAttribute("combosEstados", listaEstados);
		
		List<PeticionesDTO> listaPeticiones = peticionesServicio.buscarPeticiones(idPeticion, idCliente, idProducto, cantidad, idEstado, fechaPedido);
		model.addAttribute("listaPeticiones", listaPeticiones);
		return "peticiones/listadoPeticiones";
	}
	@GetMapping("/peticiones/insertarpeticiones")
	public String getFormularioInsertarPeticiones(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		List<ComboDTO> listaClientes = combosDAO.recuperarListaClientes();
		model.addAttribute("combosClientes", listaClientes);
		List<ComboDTO> listaProductos = combosDAO.recuperarListaProductos();
		model.addAttribute("combosProductos", listaProductos);
		List<ComboDTO> listaEstados = combosDAO.recuperarListaEstados();
		model.addAttribute("combosEstados", listaEstados);
		
		return "peticiones/insertarPeticiones";
	}
	@PostMapping("/peticiones/insertarpeticiones")
	public String insertarPeticiones(@RequestParam("idCliente") String idCliente,
			@RequestParam("idProducto") String idProducto,
			@RequestParam("cantidad") String cantidad,
			@RequestParam("idEstado") String idEstado, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		
		List<ComboDTO> listaClientes = combosDAO.recuperarListaClientes();
		model.addAttribute("combosClientes", listaClientes);
		List<ComboDTO> listaProductos = combosDAO.recuperarListaProductos();
		model.addAttribute("combosProductos", listaProductos);
		List<ComboDTO> listaEstados = combosDAO.recuperarListaEstados();
		model.addAttribute("combosEstados", listaEstados);
		
		Integer resultado = peticionesServicio.insertarPeticiones(idCliente, idProducto, cantidad, idEstado);
		model.addAttribute("resultado", resultado);
		return "peticiones/insertarPeticiones";
	}
	
	@GetMapping("/peticiones/formularioactualizarpeticiones")
	public String getFormularioactualizarClientes(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaClientes = combosDAO.recuperarListaClientes();
		model.addAttribute("combosClientes", listaClientes);
		List<ComboDTO> listaProductos = combosDAO.recuperarListaProductos();
		model.addAttribute("combosProductos", listaProductos);
		List<ComboDTO> listaEstados = combosDAO.recuperarListaEstados();
		model.addAttribute("combosEstados", listaEstados);
		return "peticiones/actualizarPeticiones";
	}
	
	@PostMapping("/peticiones/formularioactualizarpeticiones")
	public String actualizarPeticiones(@RequestParam("idPeticion") String idPeticion,
			@RequestParam("idCliente") String idCliente,
			@RequestParam("idProducto") String idProducto,
			@RequestParam("cantidad") String cantidad,
			@RequestParam("idEstado") String idEstado,
			@RequestParam("fechaPedido") String fechaPedido, ModelMap model)
					throws ClassNotFoundException, SQLException, NamingException {
		if(fechaPedido.equals("")) {
			fechaPedido = "1971-01-01";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		if (fechaPedido == "") {
			fechaPedido = sdf.format(new Date());
		}
		List<ComboDTO> listaClientes = combosDAO.recuperarListaClientes();
		model.addAttribute("combosClientes", listaClientes);
		List<ComboDTO> listaProductos = combosDAO.recuperarListaProductos();
		model.addAttribute("combosProductos", listaProductos);
		List<ComboDTO> listaEstados = combosDAO.recuperarListaEstados();
		model.addAttribute("combosEstados", listaEstados);
		
		List<PeticionesDTO> listaPeticiones = peticionesServicio.buscarPeticionesParaModificar(idPeticion, idCliente, idProducto, cantidad, idEstado, fechaPedido);
		model.addAttribute("listaPeticiones", listaPeticiones);
		return "peticiones/actualizarPeticiones";
	}
	
	@PostMapping("/peticiones/actualizarpeticiones")
	public String actualizarPeticion(@RequestParam("idPeticion") String idPeticion,
			@RequestParam("idCliente") String idCliente,
			@RequestParam("idProducto") String idProducto,
			@RequestParam("cantidad") String cantidad,
			@RequestParam("idEstado") String idEstado,
			@RequestParam("fechaPedido") String fechaPedido, ModelMap model)
					throws ClassNotFoundException, SQLException, NamingException {
		
		if(fechaPedido.equals("")) {
			fechaPedido = "1971-01-01";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		if (fechaPedido == "") {
			fechaPedido = sdf.format(new Date());
		}
		List<ComboDTO> listaClientes = combosDAO.recuperarListaClientes();
		model.addAttribute("combosClientes", listaClientes);
		List<ComboDTO> listaProductos = combosDAO.recuperarListaProductos();
		model.addAttribute("combosProductos", listaProductos);
		List<ComboDTO> listaEstados = combosDAO.recuperarListaEstados();
		model.addAttribute("combosEstados", listaEstados);
		
		Integer resultado = peticionesServicio.modificarPeticiones(idPeticion, idCliente, idProducto, cantidad, idEstado, fechaPedido);
		model.addAttribute("resultado", resultado);
		
		return "peticiones/actualizarPeticiones";
	}
	@GetMapping("/peticiones/formularioborrarpeticiones")
	public String formularioBorrarPeticiones(ModelMap model) throws ClassNotFoundException, SQLException, NamingException{
		
		List<ComboDTO> listaClientes = combosDAO.recuperarListaClientes();
		model.addAttribute("combosClientes", listaClientes);
		List<ComboDTO> listaProductos = combosDAO.recuperarListaProductos();
		model.addAttribute("combosProductos", listaProductos);
		List<ComboDTO> listaEstados = combosDAO.recuperarListaEstados();
		model.addAttribute("combosEstados", listaEstados);
		
		return "peticiones/borrarPeticiones";
	}
	
	@PostMapping("/peticiones/formularioborrarpeticiones")
	public String getFormularioBorrarPeticiones(@RequestParam("idPeticion") String idPeticion,
			@RequestParam("idCliente") String idCliente,
			@RequestParam("idProducto") String idProducto,
			@RequestParam("cantidad") String cantidad,
			@RequestParam("idEstado") String idEstado,
			@RequestParam("fechaPedido") String fechaPedido, ModelMap model)
					throws ClassNotFoundException, SQLException, NamingException {
		
		if(fechaPedido.equals("")) {
			fechaPedido = "1971-01-01";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		if (fechaPedido == "") {
			fechaPedido = sdf.format(new Date());
		}
		
		List<ComboDTO> listaClientes = combosDAO.recuperarListaClientes();
		model.addAttribute("combosClientes", listaClientes);
		List<ComboDTO> listaProductos = combosDAO.recuperarListaProductos();
		model.addAttribute("combosProductos", listaProductos);
		List<ComboDTO> listaEstados = combosDAO.recuperarListaEstados();
		model.addAttribute("combosEstados", listaEstados);
		
		List<PeticionesDTO> listaPeticiones = peticionesServicio.buscarPeticionesParaModificar(idPeticion, idCliente, idProducto, cantidad, idEstado, fechaPedido);
		model.addAttribute("listaPeticiones", listaPeticiones);
		
		return "peticiones/borrarPeticiones";
	}
	@PostMapping("/peticiones/borrarpeticiones")
	public String borrarPeticiones(@RequestParam("idPeticion") String idPeticion,
			@RequestParam("idCliente") String idCliente,
			@RequestParam("idProducto") String idProducto,
			@RequestParam("cantidad") String cantidad,
			@RequestParam("idEstado") String idEstado,
			@RequestParam("fechaPedido") String fechaPedido, ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		if(fechaPedido.equals("")) {
			fechaPedido = "1971-01-01";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		if (fechaPedido == "") {
			fechaPedido = sdf.format(new Date());
		}
		
		List<ComboDTO> listaClientes = combosDAO.recuperarListaClientes();
		model.addAttribute("combosClientes", listaClientes);
		List<ComboDTO> listaProductos = combosDAO.recuperarListaProductos();
		model.addAttribute("combosProductos", listaProductos);
		List<ComboDTO> listaEstados = combosDAO.recuperarListaEstados();
		model.addAttribute("combosEstados", listaEstados);
		
		Integer resultado = peticionesServicio.borrarPeticiones(idPeticion);
		model.addAttribute("resultado", resultado);
		
		return "peticiones/borrarPeticiones";
	}
}
