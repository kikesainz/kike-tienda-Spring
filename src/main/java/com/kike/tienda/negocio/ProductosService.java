package com.kike.tienda.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.kike.tienda.dao.IProductosDAO;
import com.kike.tienda.daojdbcimpl.ProductosDAOImplJdbc;
import com.kike.tienda.dtos.ProductosDTO;

@Component
public class ProductosService implements IProductosService{

	@Autowired
	@Qualifier("JPAProductos")
	IProductosDAO productosDAO;
	@Override
	public List<ProductosDTO> buscarProducto(String idProducto, String nombre, String descripcion, Double precio,
			Integer cantidadStock, String idCategorias, String idProveedores)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return productosDAO.buscarProducto(idProducto, nombre, descripcion, precio, cantidadStock, idCategorias, idProveedores);
	}

	@Override
	public Integer insertarProducto(String nombre, String descripcion, Double precio,
			Integer cantidadStock, String idCategorias, String idProveedores)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return productosDAO.insertarProducto(nombre, descripcion, precio, cantidadStock, idCategorias, idProveedores);
	}

	@Override
	public Integer actualizarProducto(String idProducto, String nombre, String descripcion, Double precio,
			Integer cantidadStock, String idCategorias, String idProveedores)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return productosDAO.actualizarProducto(idProducto, nombre, descripcion, precio, cantidadStock, idCategorias, idProveedores);
	}






	
}
