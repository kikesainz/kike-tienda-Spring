package com.kike.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.kike.tienda.dtos.ProveedoresDTO;

public interface IProveedoresDAO {

	public List<ProveedoresDTO> buscarProveedor(String idProveedor, String nombre, String contacto, String telefono, String correoElectronico, String direccion, String activo) throws ClassNotFoundException, SQLException, NamingException;
	
	public Integer insertarProveedor(String idProveedor, String nombre, String contacto, String telefono, String correoElectronico, String direccion, String activo) throws ClassNotFoundException, SQLException, NamingException;
	
	public Integer actualizarProvedor(String idProveedor, String nombre, String contacto, String telefono, String correoElectronico, String direccion, String activo) throws ClassNotFoundException, SQLException, NamingException;
	
}
