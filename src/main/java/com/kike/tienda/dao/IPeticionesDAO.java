package com.kike.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.kike.tienda.dtos.PeticionesDTO;

public interface IPeticionesDAO {

	public List<PeticionesDTO> buscarPeticiones(String idPeticion, String idCliente, String idProducto, String cantidad, String idEstado, String fechaPedido)
			throws ClassNotFoundException, SQLException, NamingException;
	
	public Integer insertarPeticiones(String idCliente, String idProducto, String cantidad, String idEstado)
			throws ClassNotFoundException, SQLException, NamingException;
	
	public Integer modificarPeticiones(String idPeticion, String idCliente, String idProducto, String cantidad, String idEstado, String fechaPedido)
			throws ClassNotFoundException, SQLException, NamingException;
	public List<PeticionesDTO> buscarPeticionesParaModificar(String idPeticion, String idCliente, String idProducto, String cantidad, String idEstado, String fechaPedido)
			throws ClassNotFoundException, SQLException, NamingException;
	public Integer borrarPeticiones(String idPeticion) throws ClassNotFoundException, SQLException, NamingException;
}
