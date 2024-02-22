package com.kike.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.kike.tienda.dtos.ClientesDTO;

public interface IClientesDAO {

	public List<ClientesDTO> buscarClientes(String idClientes, String nombre, String correoElectronico,
			String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarClientes(String nombre, String correoElectronico, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer actualizarClientes(String idClientes, String nombre, String correoElectronico, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer borrarClientes(String idClientes) throws ClassNotFoundException, SQLException, NamingException;
}
