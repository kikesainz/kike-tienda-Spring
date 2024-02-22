package com.kike.tienda.daojdbcimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import com.kike.tienda.dao.ICategoriasDAO;
import com.kike.tienda.dtos.CategoriasDTO;
import com.kike.tienda.utils.DBUtils;

@Component("JDBCCategorias")
public class CategoriasDAOImplJdbc implements ICategoriasDAO {

	@Override
	public List<CategoriasDTO> buscarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		String sql = "select c.ID_Categoria, c.Nombre, c.Descripcion, c.Activo from categorias c "
				+ "where c.ID_Categoria like ? and c.Nombre like ? and c.Descripcion like ? and c.Activo = ?;";

		Connection connection = DBUtils.conectaBBDD();

		List<CategoriasDTO> listaCategorias = new ArrayList<CategoriasDTO>();

		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, "%" + id + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + descripcion + "%");
		ps.setString(4, activo);

		ResultSet rs = ps.executeQuery();
		
		System.out.println(ps.toString());
		
		while (rs.next()) {
			listaCategorias.add(new CategoriasDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));

		}
		connection.close();
		return listaCategorias;
	}

	@Override
	public Integer insertarCategorias(String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		String sql = "insert into categorias (Nombre, Descripcion, Activo) values (?, ?, ?);";

		Connection connection = DBUtils.conectaBBDD();

		List<CategoriasDTO> listaCategorias = new ArrayList<CategoriasDTO>();

		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, nombre);
		ps.setString(2, descripcion);
		ps.setString(3, activo);
		
		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

	@Override
	public Integer actualizarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		
		String sql ="update categorias set Nombre = ?, Descripcion = ?, Activo = ? "
				+ " where ID_Categoria = ?; ";
		
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
	
		ps.setString(1, nombre);
		ps.setString(2, descripcion);
		ps.setString(3, activo);
		ps.setString(4, id);
		
		
		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

	@Override
	public Integer borrarCategorias(String id) throws ClassNotFoundException, SQLException, NamingException {
		
		String sql ="update categorias set activo = 0 where ID_Categoria = ?; ";
		
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
	


		ps.setString(1, id);
		
		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

}
