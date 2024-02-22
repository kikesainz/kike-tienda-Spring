package com.kike.tienda.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.kike.tienda.dao.IClientesDAO;
import com.kike.tienda.daojdbcimpl.ClientesDAOImplJdbc;
import com.kike.tienda.dtos.ClientesDTO;

@Component
public class ClientesService implements IClientesService{

	@Autowired
	@Qualifier("JPAClientes")
	IClientesDAO clientesDAO;
	@Override
	public List<ClientesDTO> buscarClientes(String idClientes, String nombre, String correoElectronico,
			String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		
		return clientesDAO.buscarClientes(idClientes, nombre, correoElectronico, idPoblacion, activo);
	}

	@Override
	public Integer insertarClientes(String nombre, String correoElectronico, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		
		return clientesDAO.insertarClientes(nombre, correoElectronico, idPoblacion, activo);
	}

	@Override
	public Integer actualizarClientes(String idClientes, String nombre, String correoElectronico, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		
		return clientesDAO.actualizarClientes(idClientes, nombre, correoElectronico, idPoblacion, activo);
	}

	@Override
	public Integer borrarClientes(String idClientes) throws ClassNotFoundException, SQLException, NamingException {
	
		return clientesDAO.borrarClientes(idClientes);
	}

}
