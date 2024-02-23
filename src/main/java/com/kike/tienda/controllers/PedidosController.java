package com.kike.tienda.controllers;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kike.tienda.dao.IComboDAO;
import com.kike.tienda.dtos.ClienteProductoDTO;
import com.kike.tienda.dtos.ComboDTO;
import com.kike.tienda.dtos.ItemDTO;
import com.kike.tienda.dtos.PedidosDTO;
import com.kike.tienda.negocio.IPedidosService;

@Controller
@RequestMapping("/pedidos")
public class PedidosController {

	@Autowired
	IPedidosService pedidosServicio;
	@Autowired
	IComboDAO combosDAO;

	@GetMapping("/calculaprecio")
	public String pedidosController1(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaClientes = combosDAO.recuperarListaClientes();
		model.addAttribute("combosClientes", listaClientes);
		List<ComboDTO> listaProductos = combosDAO.recuperarListaProductos();
		model.addAttribute("combosProductos", listaProductos);
		return "pedidos/insertarPedidos";
	}

	@PostMapping("/calculaprecio")
	public @ResponseBody Double calculaPrecio(ModelMap modelMap, @RequestBody ClienteProductoDTO clienteProducto)
			throws ClassNotFoundException, SQLException {

		return pedidosServicio.calcularPrecio(clienteProducto);
	}

	@PostMapping("/dopedido")
	public ResponseEntity<String> creaPedido(ModelMap modelMap, @RequestBody List<ItemDTO> lista) throws ClassNotFoundException, SQLException, NamingException {

		pedidosServicio.insertarPedidoRealizado(lista);


		return ResponseEntity.ok("OK");
	}

	@GetMapping("/listarpedidos")
	public String pedidosController(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaClientes = combosDAO.recuperarListaClientes();
		model.addAttribute("combosClientes", listaClientes);
		List<ComboDTO> listaEstados = combosDAO.recuperarListaEstados();
		model.addAttribute("combosEstados", listaEstados);

		return "pedidos/listadoPedidos";
	}

	@PostMapping("/listarpedidos")
	public String buscarPedidos(@RequestParam("idPedido") String idPedido, @RequestParam("idCliente") String idCliente,
			@RequestParam("fechaPedido") String fechaPedido, @RequestParam("idEstado") String idEstado, ModelMap model)
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
		List<ComboDTO> listaEstados = combosDAO.recuperarListaEstados();
		model.addAttribute("combosEstados", listaEstados);

		List<PedidosDTO> listaPedidos = pedidosServicio.buscarPedidos(idPedido, idCliente, fechaPedido, idEstado);
		model.addAttribute("listaPedidos", listaPedidos);
		return "pedidos/listadoPedidos";
	}

	@GetMapping("/formularioactualizarpedidos")
	public String getFormularioactualizarClientes(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaClientes = combosDAO.recuperarListaClientes();
		model.addAttribute("combosClientes", listaClientes);
		List<ComboDTO> listaEstados = combosDAO.recuperarListaEstados();
		model.addAttribute("combosEstados", listaEstados);

		return "pedidos/actualizarPedidos";
	}

	@PostMapping("/formularioactualizarpedidos")
	public String actualizarPedidos(@RequestParam("idPedido") String idPedido,
			@RequestParam("idCliente") String idCliente, @RequestParam("fechaPedido") String fechaPedido,
			@RequestParam("idEstado") String idEstado, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		
		if(fechaPedido.equals("")) {
			fechaPedido = "1971-01-01";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		if (fechaPedido == "") {
			fechaPedido = sdf.format(new Date());
		}
		
		List<PedidosDTO> listaPedidos = pedidosServicio.buscarPedidosModificar(idPedido, idCliente, fechaPedido,
				idEstado);
		model.addAttribute("listaPedidos", listaPedidos);
		
		List<ComboDTO> listaClientes = combosDAO.recuperarListaClientes();
		model.addAttribute("combosClientes", listaClientes);
		List<ComboDTO> listaEstados = combosDAO.recuperarListaEstados();
		model.addAttribute("combosEstados", listaEstados);
		List<ComboDTO> listaProductos = combosDAO.recuperarListaProductos();
		model.addAttribute("combosProductos", listaProductos);
		return "pedidos/actualizarPedidos";
	}

	@PostMapping("/actualizarpedidos")
	public String actualizarPedido(@RequestParam("idPedido") String idPedido,
			@RequestParam("idDetallePedido") String idDetallePedido, @RequestParam("idCliente") String idCliente,
			@RequestParam("idProducto") String idProducto, @RequestParam("cantidad") String cantidad,
			@RequestParam("precio") String precio, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaProductos = combosDAO.recuperarListaProductos();
		model.addAttribute("combosProductos", listaProductos);
		List<ComboDTO> listaClientes = combosDAO.recuperarListaClientes();
		model.addAttribute("combosClientes", listaClientes);
		;

		Integer resultado = pedidosServicio.actualizarPedidos(idCliente, idPedido, idProducto, cantidad, precio,
				idDetallePedido);
		return "pedidos/actualizarPedidos";
	}

}
