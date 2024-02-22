package com.kike.tienda.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.kike.tienda.dtos.ClienteProductoDTO;
import com.kike.tienda.dtos.ItemDTO;
import com.kike.tienda.dtos.PedidosDTO;

public interface IPedidosService {

	public List<PedidosDTO> buscarPedidos(String idPedido, String idCliente, String fechaPedido, String idEstado) throws ClassNotFoundException, SQLException, NamingException;
	public List<PedidosDTO> buscarPedidosModificar(String idPedido, String idCliente, String fechaPedido, String idEstado) throws ClassNotFoundException, SQLException, NamingException;
	public Integer actualizarPedidos(String idCliente, String idPedido, String idProducto, String cantidad, String precioUnitario, String idDetalle) throws ClassNotFoundException, SQLException, NamingException;
	public Double calcularPrecio(ClienteProductoDTO clienteProducto) throws ClassNotFoundException, SQLException;
	public Integer insertarPedidoRealizado(List<ItemDTO> lista) throws ClassNotFoundException, SQLException, NamingException;
}
