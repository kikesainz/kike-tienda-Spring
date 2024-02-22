package com.kike.tienda.daojdbcimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import com.kike.tienda.utils.DBUtils;
import com.kike.tienda.dao.IComboDAO;
import com.kike.tienda.dtos.ComboDTO;


public class ComboDAOImplmpl implements IComboDAO{

	@Override
	public List<ComboDTO> recuperarListaProveedores() throws ClassNotFoundException, SQLException, NamingException {

		String sql = "select ID_Proveedor, Nombre from proveedores order by Nombre;";
		
		List<ComboDTO> listaProveedores = new ArrayList<ComboDTO>();


		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			listaProveedores.add(new ComboDTO(rs.getInt(1), rs.getString(2)));
		}
		
		
		return listaProveedores;
	}

	@Override
	public List<ComboDTO> reuperarListaCategorias() throws ClassNotFoundException, SQLException, NamingException {
		
		String sql = "select ID_Categoria, Nombre from categorias order by Nombre;";
		
		List<ComboDTO> listaCategorias = new ArrayList<ComboDTO>();


		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			listaCategorias.add(new ComboDTO(rs.getInt(1), rs.getString(2)));
		}
		
		
		return listaCategorias;
	}

	@Override
	public List<ComboDTO> recuperarListaPoblacion() throws ClassNotFoundException, SQLException, NamingException {
		String sql = "select ID, Nombre from poblacion order by Nombre;";
		
		List<ComboDTO> listaPoblaciones = new ArrayList<ComboDTO>();
		
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			listaPoblaciones.add(new ComboDTO(rs.getInt(1), rs.getString(2)));
		}
		
		
		return listaPoblaciones;
	}

	@Override
	public List<ComboDTO> recuperarListaClientes() throws ClassNotFoundException, SQLException, NamingException {

		String sql = "select ID_Cliente, Nombre from clientes order by Nombre;";
		List<ComboDTO> listaClientes = new ArrayList<ComboDTO>();
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			listaClientes.add(new ComboDTO(rs.getInt(1), rs.getString(2)));
		}
		return listaClientes;
	}

	@Override
	public List<ComboDTO> recuperarListaEstados() throws ClassNotFoundException, SQLException, NamingException {
		
		String sql = "select EstadoID, NombreEstado from estadospedidos order by NombreEstado;";
		List<ComboDTO> listaEstados = new ArrayList<ComboDTO>();
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			listaEstados.add(new ComboDTO(rs.getInt(1), rs.getString(2)));
		}
		return listaEstados;
	}

	@Override
	public List<ComboDTO> recuperarListaProductos() throws ClassNotFoundException, SQLException, NamingException {

		String sql = "select ID_Producto, Nombre from productos order by Nombre;";
		List<ComboDTO> listaProductos = new ArrayList<ComboDTO>();
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			listaProductos.add(new ComboDTO(rs.getInt(1), rs.getString(2)));
		}
		return listaProductos;
		
	}
	
}
