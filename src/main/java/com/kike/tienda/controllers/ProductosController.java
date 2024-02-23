package com.kike.tienda.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
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
import com.kike.tienda.dtos.ProductosDTO;
import com.kike.tienda.negocio.IProductosService;

@Controller
public class ProductosController {

	@Autowired
	IProductosService productosServicio;
	@Autowired
	IComboDAO combosDAO;
	
	@GetMapping("/listarproductos")
	public String productosController(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		List<ComboDTO> listaCategorias = combosDAO.reuperarListaCategorias();
		List<ComboDTO> listaProveedores = combosDAO.recuperarListaProveedores();
		model.addAttribute("combosCategorias", listaCategorias);
		model.addAttribute("combosProveedores", listaProveedores);
		return "productos/listadoProductos";
	}

	@PostMapping("/listarproductos")
	public String buscarProductos(@RequestParam("idProducto") String id, 
			@RequestParam("nombre") String nombre, 
			@RequestParam("descripcion") String descripcion, 
			@RequestParam("precio") String precio, 
			@RequestParam("cantidadStock") String cantidadStock, 
			@RequestParam("idCategroria") String idCategroria, 
			@RequestParam("idProveedor") String idProveedor, 
			ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		if(precio == "") {
			precio = "0";
		}
		if(cantidadStock == "") {
			cantidadStock = "0";
		}
		Double precioDouble = Double.parseDouble(precio);
		Integer cantidad = Integer.parseInt(cantidadStock);

		List<ProductosDTO> listaProductos = productosServicio.buscarProducto(id, nombre, descripcion, precioDouble, cantidad, idCategroria, idProveedor);
		model.addAttribute("listaProductos", listaProductos);
		return "productos/listadoProductos";
	}
	
	@GetMapping("/insertarproductos")
	public String getFormularioInsertarProductos(ModelMap model)throws ClassNotFoundException, SQLException, NamingException {
	
		List<ComboDTO> listaCategorias = combosDAO.reuperarListaCategorias();
		List<ComboDTO> listaProveedores = combosDAO.recuperarListaProveedores();
		model.addAttribute("combosCategorias", listaCategorias);
		model.addAttribute("combosProveedores", listaProveedores);
		
		return "productos/insertarProductos";
	}
	
	@PostMapping("/insertarproductos")
	public String insertarProductos( 
			@RequestParam("nombre") String nombre, 
			@RequestParam("descripcion") String descripcion, 
			@RequestParam("precio") String precio, 
			@RequestParam("cantidadStock") String cantidadStock, 
			@RequestParam("idCategoria") String idCategoria, 
			@RequestParam("idProveedor") String idProveedor, 
			ModelMap model) throws ClassNotFoundException, SQLException, NamingException{
		
		if(precio == "") {
			precio = "0";
		}
		if(cantidadStock == "") {
			cantidadStock = "0";
		}
				
		Double precioDouble = Double.parseDouble(precio);
		Integer cantidad = Integer.parseInt(cantidadStock);
		
		List<ComboDTO> listaCategorias = combosDAO.reuperarListaCategorias();
		List<ComboDTO> listaProveedores = combosDAO.recuperarListaProveedores();
		model.addAttribute("combosCategorias", listaCategorias);
		model.addAttribute("combosProveedores", listaProveedores);
		
		Integer resultado = productosServicio.insertarProducto(nombre, descripcion, precioDouble, cantidad, idCategoria, idProveedor);
		model.addAttribute("resultado", resultado);
		

				
		return "productos/insertarProductos";
	}
	
	@GetMapping("/formularioactualizarproductos")
	public String getFormularioactualizarProductos(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaCategorias = combosDAO.reuperarListaCategorias();
		List<ComboDTO> listaProveedores = combosDAO.recuperarListaProveedores();
		
		model.addAttribute("combosCategorias", listaCategorias);
		model.addAttribute("combosProveedores", listaProveedores);
		return "productos/actualizarProductos";
	}
	@PostMapping("/formularioactualizarproductos")
	public String actualizarProductos(@RequestParam("idProducto") String id, 
			@RequestParam("nombre") String nombre, 
			@RequestParam("descripcion") String descripcion, 
			@RequestParam("precio") String precio, 
			@RequestParam("cantidadStock") String cantidadStock, 
			@RequestParam("idCategoria") String idCategoria, 
			@RequestParam("idProveedor") String idProveedor, 
			ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		if(precio == "") {
			precio = "0";
		}
		if(cantidadStock == "") {
			cantidadStock = "0";
		}
				
		Double precioDouble = Double.parseDouble(precio);
		Integer cantidad = Integer.parseInt(cantidadStock);
		
		List<ProductosDTO> listaProductos = productosServicio.buscarProducto(id, nombre, descripcion, precioDouble, cantidad, idCategoria, idProveedor);
		model.addAttribute("listaProductos", listaProductos);
		
		List<ComboDTO> listaCategorias = combosDAO.reuperarListaCategorias();
		List<ComboDTO> listaProveedores = combosDAO.recuperarListaProveedores();
		
		model.addAttribute("combosCategorias", listaCategorias);
		model.addAttribute("combosProveedores", listaProveedores);
		
		
		return "productos/actualizarProductos";
	}
	@PostMapping("/actualizarproductos")
	public String actualizarProducto(@RequestParam("idProducto") String id, 
			@RequestParam("nombre") String nombre, 
			@RequestParam("descripcion") String descripcion, 
			@RequestParam("precio") String precio, 
			@RequestParam("cantidadStock") String cantidadStock, 
			@RequestParam("idCategoria") String idCategoria, 
			@RequestParam("idProveedor") String idProveedor, 
			ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		if(precio == "") {
			precio = "0";
		}
		if(cantidadStock == "") {
			cantidadStock = "0";
		}
				
		Double precioDouble = Double.parseDouble(precio);
		Integer cantidad = Integer.parseInt(cantidadStock);
		
		Integer resultado = productosServicio.actualizarProducto(id, nombre, descripcion, precioDouble, cantidad, idCategoria, idProveedor);
		model.addAttribute("resultado", resultado);
		
		List<ComboDTO> listaCategorias = combosDAO.reuperarListaCategorias();
		List<ComboDTO> listaProveedores = combosDAO.recuperarListaProveedores();
		model.addAttribute("combosCategorias", listaCategorias);
		model.addAttribute("combosProveedores", listaProveedores);
		return "productos/actualizarProductos";
	}
}
