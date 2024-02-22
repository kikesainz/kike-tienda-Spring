package com.kike.tienda.daojdbcimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import com.kike.tienda.dao.IClientesDAO;
import com.kike.tienda.dtos.ClientesDTO;

import com.kike.tienda.utils.DBUtils;

@Component
public class ClientesDAOImplJdbc implements IClientesDAO {

	@Override
	public List<ClientesDTO> buscarClientes(String idClientes, String nombre, String correoElectronico,
			 String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {

		String sql = "select c.ID_Cliente, c.Nombre, c.CorreoElectronico, c.ID_Poblacion, p.Nombre, c.activo "
				+ "from clientes c inner join poblacion p on c.ID_Poblacion=p.ID "
				+ "where c.ID_Cliente like ? and c.Nombre like ? and c.CorreoElectronico like ? and c.ID_Poblacion like ? and c.activo = ?;";

		Connection connection = DBUtils.conectaBBDD();

		List<ClientesDTO> listaClientes = new ArrayList<ClientesDTO>();

		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, "%" + idClientes + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + correoElectronico + "%");
		ps.setString(4, "%" + idPoblacion + "%");
		ps.setString(5, activo);

		ResultSet rs = ps.executeQuery();

		System.out.println(ps.toString());
		
		while (rs.next()) {
			listaClientes.add(new ClientesDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
		}
		connection.close();
		return listaClientes;
	}


	@Override
	public Integer insertarClientes(String nombre, String correoElectronico, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		
		String sql = "insert into clientes (Nombre, CorreoElectronico, ID_Poblacion, activo) values (?, ?, ?, ?);";

		Connection connection = DBUtils.conectaBBDD();

		List<ClientesDTO> listaPoblaciones = new ArrayList<ClientesDTO>();
		
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, nombre);
		ps.setString(2, correoElectronico);
		ps.setString(3, idPoblacion);
		ps.setString(4, activo);

		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}



	@Override
	public Integer actualizarClientes(String idClientes, String nombre, String correoElectronico, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {


		String sql = "update clientes set Nombre = ?, CorreoElectronico = ?, ID_Poblacion = ?, activo = ? where ID_Cliente = ?;";
		
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, nombre);
		ps.setString(2, correoElectronico);
		ps.setString(3, idPoblacion);
		ps.setString(4, activo);
		ps.setString(5, idClientes);
		
		System.out.println(ps.toString());
		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

	@Override
	public Integer borrarClientes(String idClientes) throws ClassNotFoundException, SQLException, NamingException {
		
		String sql ="update clientes set activo = 0 where ID_Cliente = ?; ";
		
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
	


		ps.setString(1, idClientes);
		
		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}
}
