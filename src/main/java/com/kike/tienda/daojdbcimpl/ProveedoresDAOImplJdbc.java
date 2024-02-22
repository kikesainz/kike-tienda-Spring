package com.kike.tienda.daojdbcimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import com.kike.tienda.dao.IProveedoresDAO;
import com.kike.tienda.dtos.ProveedoresDTO;
import com.kike.tienda.utils.DBUtils;

@Component
public class ProveedoresDAOImplJdbc implements IProveedoresDAO{

	@Override
	public List<ProveedoresDTO> buscarProveedor(String idProveedor, String nombre, String contacto, String telefono, String correoElectronico,
			String direccion, String activo) throws ClassNotFoundException, SQLException, NamingException {
		
		String sql = "select ID_Proveedor, Nombre, Contacto, Telefono, CorreoElectronico, Direccion, Activo "
				+ "from proveedores where ID_Proveedor like ? "
				+ "and Nombre like ? "
				+ "and Contacto like ? "
				+ "and Telefono like ? "
				+ "and CorreoElectronico like ? "
				+ "and Direccion like ? "
				+ "and Activo like ?;";
		
		Connection connection = DBUtils.conectaBBDD();
		List<ProveedoresDTO> listaProveedores = new ArrayList<ProveedoresDTO>();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, "%" + idProveedor + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + contacto + "%");
		ps.setString(4, "%" + telefono + "%");
		ps.setString(5, "%" + correoElectronico + "%");
		ps.setString(6, "%" + direccion + "%");
		ps.setString(7, activo);
		
		ResultSet rs = ps.executeQuery();

		System.out.println(ps.toString());
		
		while (rs.next()) {
			listaProveedores.add(new ProveedoresDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
		}
		connection.close();
		return listaProveedores;
	}

	@Override
	public Integer insertarProveedor(String idProveedor, String nombre, String contacto, String telefono, String correoElectronico,
			String direccion, String activo) throws ClassNotFoundException, SQLException, NamingException {
		
		String sql = "insert into proveedores (ID_Proveedor, Nombre, Contacto, Telefono, CorreoElectronico, Direccion, Activo) values (?, ?, ?, ?, ?, ?, ?);";
		
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, idProveedor);
		ps.setString(2, nombre);
		ps.setString(3, contacto);
		ps.setString(4, telefono);
		ps.setString(5, correoElectronico);
		ps.setString(6, direccion);
		ps.setString(7, activo);
		
		System.out.println(ps.toString());
		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

	@Override
	public Integer actualizarProvedor(String idProveedor, String nombre, String contacto, String telefono, String correoElectronico,
			String direccion, String activo) throws ClassNotFoundException, SQLException, NamingException {
		String sql = "update proveedores set Nombre = ?, Contacto = ?, Telefono = ?, CorreoElectronico = ?, Direccion = ?, Activo = ? where ID_Proveedor = ?;";
		
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, nombre);
		ps.setString(2, contacto);
		ps.setString(3, telefono);
		ps.setString(4, correoElectronico);
		ps.setString(5, direccion);
		ps.setString(6, activo);
		ps.setString(7, idProveedor);
		
		System.out.println(ps.toString());
		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

	
	
}
