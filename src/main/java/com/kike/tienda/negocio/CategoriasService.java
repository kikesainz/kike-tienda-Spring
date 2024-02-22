package com.kike.tienda.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.kike.tienda.dao.ICategoriasDAO;
import com.kike.tienda.daojdbcimpl.CategoriasDAOImplJdbc;
import com.kike.tienda.dtos.CategoriasDTO;

@Component
public class CategoriasService implements ICaregoriasService{

	@Autowired
	@Qualifier("JPACategorias")
	ICategoriasDAO categoriasDAO;
	@Override
	public List<CategoriasDTO> buscarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		return categoriasDAO.buscarCategorias(id, nombre, descripcion, activo);
	}

	@Override
	public Integer insertarCategorias(String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		return categoriasDAO.insertarCategorias(nombre, descripcion, activo);
	}

	@Override
	public Integer actualizarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		return categoriasDAO.actualizarCategorias(id, nombre, descripcion, activo);
	}

	@Override
	public Integer borrarCategorias(String id) throws ClassNotFoundException, SQLException, NamingException {
		return categoriasDAO.borrarCategorias(id);
	}

	
}
