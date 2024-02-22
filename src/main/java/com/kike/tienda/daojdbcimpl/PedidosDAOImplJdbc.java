package com.kike.tienda.daojdbcimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Controller;

import com.kike.tienda.dao.IPedidosDAO;
import com.kike.tienda.dtos.ClienteProductoDTO;
import com.kike.tienda.dtos.ItemDTO;
import com.kike.tienda.dtos.PedidosDTO;
import com.kike.tienda.utils.DBUtils;

@Controller
public class PedidosDAOImplJdbc implements IPedidosDAO {

	@Override
	public List<PedidosDTO> buscarPedidos(String idPedido, String idCliente, String fechaPedido, String idEstado)
			throws ClassNotFoundException, SQLException, NamingException {

		String sql = "select p.ID_Pedido, c.Nombre, pr.Nombre, d.Cantidad, d.PrecioUnitario "
				+ "from clientes c inner join pedidos p on c.ID_Cliente=p.ID_Cliente "
				+ "inner join detalles_pedido d on p.ID_Pedido=d.ID_Pedido "
				+ "inner join productos pr on d.ID_Producto=pr.ID_Producto " + "where p.ID_Pedido like ? "
				+ "and p.ID_Cliente like ? " + "and p.FechaPedido >= ? " + "and p.EstadoID like ?;";

		Connection connection = DBUtils.conectaBBDD();

		List<PedidosDTO> listaPedidos = new ArrayList<PedidosDTO>();

		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, "%" + idPedido + "%");
		ps.setString(2, "%" + idCliente + "%");
		ps.setString(3, fechaPedido);
		ps.setString(4, "%" + idEstado + "%");

		ResultSet rs = ps.executeQuery();

		System.out.println(ps.toString());

		while (rs.next()) {

			listaPedidos
					.add(new PedidosDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5)));

		}
		connection.close();
		return listaPedidos;
	}

	@Override
	public List<PedidosDTO> buscarPedidosModificar(String idPedido, String idCliente, String fechaPedido,
			String idEstado) throws ClassNotFoundException, SQLException, NamingException {
		String sql = "select p.ID_Pedido, p.ID_Cliente, c.Nombre, d.ID_Producto, pr.Nombre, d.Cantidad, d.PrecioUnitario, d.ID_Detalle "
				+ "from clientes c inner join pedidos p on c.ID_Cliente=p.ID_Cliente "
				+ "inner join detalles_pedido d on p.ID_Pedido=d.ID_Pedido "
				+ "inner join productos pr on d.ID_Producto=pr.ID_Producto "
				+ "where p.ID_Pedido like ? "
				+ "and p.ID_Cliente like ? "
				+ "and p.FechaPedido >= ? "
				+ "and p.EstadoID like ?;";
		
		Connection connection = DBUtils.conectaBBDD();

		List<PedidosDTO> listaPedidos = new ArrayList<PedidosDTO>();

		PreparedStatement ps = connection.prepareStatement(sql);
		
		
		ps.setString(1, "%" + idPedido + "%");
		ps.setString(2, "%" + idCliente + "%");
		ps.setString(3, fechaPedido);
		ps.setString(4, "%" + idEstado + "%");

		ResultSet rs = ps.executeQuery();

		System.out.println(ps.toString());

		while (rs.next()) {
			listaPedidos
					.add(new PedidosDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDouble(7), rs.getInt(8)));
		}
		connection.close();
		return listaPedidos;
	}

	@Override
	public Integer insertarPedidos(List<ItemDTO> lista) {
		
		String sql1 = "insert into pedidos (ID_Cliente, EstadoID) values (?, 1);";
		String sql2 = "insert into detalles_pedido (ID_Pedido, ID_Producto, Cantidad, PrecioUnitario) values (?, ?, ?, ?);";
		String sql3 = "update productos set CantidadEnStock = (CantidadEnStock - ?) where ID_Producto = ?;";
		
		String clienteID = "";
		
		for (ItemDTO i : lista) {
			Integer idCliente = i.getClienteID();
			clienteID = idCliente + "";	
		}
		
		Integer filasInsertadas = 0;
		Integer resultado = 0;
		Integer idPedido = 0;
		
		Connection connection = null;
		
		try {
			connection = DBUtils.conectaBBDD();
			PreparedStatement psPedido = connection.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
				connection.setAutoCommit(false);
				psPedido.setString(1, clienteID);
				
			System.out.println(psPedido.toString());
			filasInsertadas = psPedido.executeUpdate();
			
			if(filasInsertadas == 0) {
				throw new SQLException("Ha fallado la inserción del pedido");
			}
			
			ResultSet clavesGeneradas = psPedido.getGeneratedKeys();
			
			if(clavesGeneradas.next()) {
				idPedido = clavesGeneradas.getInt(1);
			}else {
				throw new SQLException("Insert fallido, no se ha obtenido el id");
			}
			
			for (ItemDTO i : lista) {
				
			PreparedStatement ps2 = connection.prepareStatement(sql2);
			
			ps2.setInt(1, idPedido);
			ps2.setInt(2, i.getProductoID());
			ps2.setInt(3, i.getCantidad());
			ps2.setDouble(4, i.getPrecio());
			
			System.out.println(ps2.toString());
			resultado = ps2.executeUpdate();
			
			PreparedStatement ps3 = connection.prepareStatement(sql3);
			ps3.setInt(1, i.getCantidad());
			ps3.setInt(2, i.getProductoID());
			
			System.out.println(ps3.toString());
			resultado = ps3.executeUpdate();
			}

			connection.commit();
			connection.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultado;
	}

	@Override
	public Integer actualizarPedidos(String idCliente, String idPedido, String idProducto, String cantidad, String precioUnitario, String idDetalle)
			 {
		
		String sql1 = "update pedidos set ID_Cliente = ? where ID_Pedido = ?;";
		String sql2 = "update detalles_pedido set ID_Producto = ?,  Cantidad = ?,  PrecioUnitario = ? where ID_Detalle = ?;";
		Integer resultado = 0;
		
		Connection connection = null;
		try {
			connection = DBUtils.conectaBBDD();
			connection.setAutoCommit(false);
			PreparedStatement ps1 = connection.prepareStatement(sql1);
			PreparedStatement ps2 = connection.prepareStatement(sql2);
			
			ps1.setString(1, idCliente);
			ps1.setString(2, idPedido);
			ps2.setString(1, idProducto);
			ps2.setString(2, cantidad);
			ps2.setString(3, precioUnitario);
			ps2.setString(4, idDetalle);
			
			System.out.println(ps1.toString());
			System.out.println(ps2.toString());
			
			resultado = ps1.executeUpdate();			
			resultado = ps2.executeUpdate();

			connection.commit();
			connection.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultado;
		
	}

	@Override
	public Double buscarPrecioAcumulado(Integer cliente) throws ClassNotFoundException, SQLException {
		String sql = "select sum(d.PrecioUnitario)  from clientes c "
				+ " inner join pedidos p on c.ID_Cliente=p.ID_Cliente "
				+ " inner join detalles_pedido d on p.ID_Pedido=d.ID_Pedido "
				+ " where p.ID_Cliente = ?;";
		
		Connection connection = DBUtils.conectaBBDD();
		
		Double precioAcumulado = 0.0;
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1, cliente);
		
		ResultSet rs = ps.executeQuery();

		System.out.println(ps.toString());
		
		rs.next();
		precioAcumulado = rs.getDouble(1);
	
		
		connection.close();
		return precioAcumulado;

	}

	@Override
	public Double buscarDescuento(Double precioAcumulado) throws ClassNotFoundException, SQLException {

		String sql = "select descuento from descuentos where cantidad >= ? limit 1;";
		Connection connection = DBUtils.conectaBBDD();
		
		Double descuento = 0.0;
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setDouble(1, precioAcumulado);
		
		ResultSet rs = ps.executeQuery();

		System.out.println(ps.toString());
		
		rs.next();
		descuento = rs.getDouble(1);
	
		
		connection.close();
		return descuento;
	}

	@Override
	public Double buscarPrecioProducto(Integer producto) throws ClassNotFoundException, SQLException {
		
		String sql = "select Precio from productos where ID_Producto = ?;";
		Connection connection = DBUtils.conectaBBDD();
		
		Double precio = 0.0;
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setDouble(1, producto);
		
		ResultSet rs = ps.executeQuery();

		System.out.println(ps.toString());
		
		rs.next();
		precio = rs.getDouble(1);
	
		
		connection.close();
		return precio;
	}
	
	

}
