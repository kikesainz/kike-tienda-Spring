package com.kike.tienda.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.kike.tienda.dao.IProveedoresDAO;
import com.kike.tienda.dtos.ProveedoresDTO;

@Component
public class ProveedoresService implements IProveedoresService{

	@Autowired
	@Qualifier("JPAProveedores")
	IProveedoresDAO proveedoresDAO;
	
	@Override
	public List<ProveedoresDTO> buscarProveedor(String idProveedor, String nombre, String contacto, String telefono, String correoElectronico,
			String direccion, String activo) throws ClassNotFoundException, SQLException, NamingException {
		
		return proveedoresDAO.buscarProveedor(idProveedor, nombre, contacto, telefono, correoElectronico, direccion, activo);
	}

	@Override
	public Integer insertarProveedor(String idProveedor, String nombre, String contacto, String telefono, String correoElectronico, String direccion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		
		return proveedoresDAO.insertarProveedor(idProveedor, nombre, contacto, telefono, correoElectronico, direccion, activo);
	}

	@Override
	public Integer actualizarProvedor(String idProveedor, String nombre, String contacto, String telefono, String correoElectronico,
			String direccion, String activo) throws ClassNotFoundException, SQLException, NamingException {
		
		return proveedoresDAO.actualizarProvedor(idProveedor, nombre, contacto, telefono, correoElectronico, direccion, activo);
	}

}
