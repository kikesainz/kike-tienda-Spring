package com.kike.tienda.daojdbcimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import com.kike.tienda.dao.IPeticionesDAO;
import com.kike.tienda.dtos.PeticionesDTO;
import com.kike.tienda.utils.DBUtils;

@Component
public class PeticionesDAOImplJdbc implements IPeticionesDAO{


	public List<PeticionesDTO> buscarPeticiones(String idPeticion, String idCliente, String idProducto, String cantidad, String idEstado, String fechaPedido)
			throws ClassNotFoundException, SQLException, NamingException{
		
		String sql = "select pe.ID_Peticiones, c.Nombre, pr.Nombre, pe.FechaAñadido "
				+ "from peticiones pe inner join clientes c on pe.ID_Cliente = c.ID_Cliente "
				+ "inner join productos pr on pe.ID_Producto=pr.ID_Producto "
				+ "where pe.ID_Peticiones like ? "
				+ "and pe.ID_Cliente like ? "
				+ "and pe.ID_Producto like ? "
				+ "and pe.FechaAñadido >= ? "
				+ "and pe.cantidad >= ? "
				+ "and pe.Estado like ?;";
		
		Connection connection = DBUtils.conectaBBDD();
		
		List<PeticionesDTO> listaPeticiones = new ArrayList<PeticionesDTO>();
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, "%" + idPeticion + "%");
		ps.setString(2, "%" + idCliente + "%");
		ps.setString(3, "%" + idProducto + "%");
		ps.setString(4, fechaPedido);
		ps.setString(5, cantidad);
		ps.setString(6, "%" + idEstado + "%");
		
		ResultSet rs = ps.executeQuery();

		System.out.println(ps.toString());
		
		while (rs.next()) {
			listaPeticiones.add(new PeticionesDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		connection.close();
		
		return listaPeticiones;
	}

	@Override
	public Integer insertarPeticiones(String idCliente, String idProducto, String cantidad, String idEstado)
			throws ClassNotFoundException, SQLException, NamingException {
		String sql = "insert into peticiones (ID_Cliente, ID_Producto, cantidad, Estado) values (?, ?, ?, ?);";
		
		Connection connection = DBUtils.conectaBBDD();
		
		List<PeticionesDTO> listaPeticiones = new ArrayList<PeticionesDTO>();
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, idCliente);
		ps.setString(2, idProducto);
		ps.setString(3, cantidad);
		ps.setString(4, idEstado);
		
		Integer resultado = ps.executeUpdate();
		
		connection.close();
		return resultado;
	}

	@Override
	public Integer modificarPeticiones(String idPeticion, String idCliente, String idProducto, String cantidad,
			String idEstado, String fechaPedido) throws ClassNotFoundException, SQLException, NamingException {
		String sql = "update peticiones set ID_Cliente = ?, ID_Producto = ?, FechaAñadido = ?, cantidad = ?, Estado = ? where ID_Peticiones = ?;";
		
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, idCliente);
		ps.setString(2, idProducto);
		ps.setString(3, fechaPedido);
		ps.setString(4, cantidad);
		ps.setString(5, idEstado);
		ps.setString(6, idPeticion);
		
		
		System.out.println(ps.toString());
		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

	@Override
	public List<PeticionesDTO> buscarPeticionesParaModificar(String idPeticion, String idCliente, String idProducto,
			String cantidad, String idEstado, String fechaPedido)
			throws ClassNotFoundException, SQLException, NamingException {
		String sql = "select pe.ID_Peticiones, pe.ID_Cliente, c.Nombre, pe.ID_Producto, pr.Nombre, pe.FechaAñadido, pe.cantidad, pe.Estado, e.NombreEstado from peticiones pe inner join clientes c on pe.ID_Cliente = c.ID_Cliente inner join productos pr on pe.ID_Producto=pr.ID_Producto inner join estadospedidos e on pe.Estado=e.EstadoID where pe.ID_Peticiones like ? and pe.ID_Cliente like ? and pe.ID_Producto like ? and pe.FechaAñadido >= ? and pe.cantidad >= ? and pe.Estado like ?;";
		
		Connection connection = DBUtils.conectaBBDD();
		
		List<PeticionesDTO> listaPeticiones = new ArrayList<PeticionesDTO>();
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, "%" + idPeticion + "%");
		ps.setString(2, "%" + idCliente + "%");
		ps.setString(3, "%" + idProducto + "%");
		ps.setString(4, fechaPedido);
		ps.setString(5, cantidad);
		ps.setString(6, "%" + idEstado + "%");
		
		ResultSet rs = ps.executeQuery();

		System.out.println(ps.toString());
		
		while (rs.next()) {
			listaPeticiones.add(new PeticionesDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9)));
		}
		connection.close();
		
		return listaPeticiones;
	}

	@Override
	public Integer borrarPeticiones(String idPeticion) throws ClassNotFoundException, SQLException, NamingException {

		String sql = "update peticiones set Estado = 5 where ID_Peticiones like ?;";
		
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
	


		ps.setString(1, idPeticion);
		
		
		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}
}
