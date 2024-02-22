package com.kike.tienda.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.kike.tienda.dtos.CategoriasDTO;

public interface ICaregoriasService {

	public List<CategoriasDTO> buscarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarCategorias(String nombre, String descripcion, String activo) throws ClassNotFoundException, SQLException, NamingException;

	public Integer actualizarCategorias(String id, String nombre, String descripcion, String activo) throws ClassNotFoundException, SQLException, NamingException;
	
	public Integer borrarCategorias(String id) throws ClassNotFoundException, SQLException, NamingException;
}
