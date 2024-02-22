package com.kike.tienda.negocio;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.kike.tienda.dao.IPedidosDAO;
import com.kike.tienda.dtos.ClienteProductoDTO;
import com.kike.tienda.dtos.ItemDTO;
import com.kike.tienda.dtos.PedidosDTO;

@Component
public class PedidosService implements IPedidosService {

	@Autowired
	@Qualifier("JPAPedidos")
	IPedidosDAO pedidosDAO;

	@Override
	public List<PedidosDTO> buscarPedidos(String idPedido, String idCliente, String fechaPedido, String idEstado)
			throws ClassNotFoundException, SQLException, NamingException {

		return pedidosDAO.buscarPedidos(idPedido, idCliente, fechaPedido, idEstado);
	}

	@Override
	public List<PedidosDTO> buscarPedidosModificar(String idPedido, String idCliente, String fechaPedido,
			String idEstado) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return pedidosDAO.buscarPedidosModificar(idPedido, idCliente, fechaPedido, idEstado);
	}



	@Override
	public Integer actualizarPedidos(String idCliente, String idPedido, String idProducto, String cantidad,
			String precioUnitario, String idDetalle) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return pedidosDAO.actualizarPedidos(idCliente, idPedido, idProducto, cantidad, precioUnitario, idDetalle);
	}

	@Override
	public Double calcularPrecio(ClienteProductoDTO clienteProducto) throws ClassNotFoundException, SQLException {
		
		Integer cliente = clienteProducto.getCliente();
		Integer producto = clienteProducto.getProducto();
		
		Double precioAcumulado = pedidosDAO.buscarPrecioAcumulado(cliente);
		Double descuento = pedidosDAO.buscarDescuento(precioAcumulado);
		Double precio = pedidosDAO.buscarPrecioProducto(producto);
		
		Double precioFinal = precio -= (precio * (descuento/100));
		
		return precioFinal;
	}

	@Override
	public Integer insertarPedidoRealizado(List<ItemDTO> lista)
			throws ClassNotFoundException, SQLException, NamingException {
		
		return pedidosDAO.insertarPedidos(lista);
	}





}
