package com.kike.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.kike.tienda.dtos.ProductosDTO;

public interface IProductosDAO {

	public List<ProductosDTO> buscarProducto(String idProducto, String nombre, String descripcion, Double precio, Integer cantidadStock, String idCategorias, String idProveedores)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarProducto(String nombre, String descripcion, Double precio, Integer cantidadStock, String idCategorias, String idProveedores) throws ClassNotFoundException, SQLException, NamingException;

	public Integer actualizarProducto(String idProducto, String nombre, String descripcion, Double precio, Integer cantidadStock, String idCategorias, String idProveedores) throws ClassNotFoundException, SQLException, NamingException;
	

}
