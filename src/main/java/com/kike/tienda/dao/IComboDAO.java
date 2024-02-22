package com.kike.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.kike.tienda.dtos.ComboDTO;

public interface IComboDAO {

	public List<ComboDTO> recuperarListaProveedores() throws ClassNotFoundException, SQLException, NamingException;
	public List<ComboDTO> reuperarListaCategorias() throws ClassNotFoundException, SQLException, NamingException;
	public List<ComboDTO> recuperarListaPoblacion() throws ClassNotFoundException, SQLException, NamingException;
	public List<ComboDTO> recuperarListaClientes() throws ClassNotFoundException, SQLException, NamingException;
	public List<ComboDTO> recuperarListaEstados() throws ClassNotFoundException, SQLException, NamingException;
	public List<ComboDTO> recuperarListaProductos() throws ClassNotFoundException, SQLException, NamingException;
}
