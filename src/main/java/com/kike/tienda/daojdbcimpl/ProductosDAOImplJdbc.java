package com.kike.tienda.daojdbcimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import com.kike.tienda.utils.DBUtils;
import com.kike.tienda.dao.IProductosDAO;
import com.kike.tienda.dtos.ProductosDTO;

@Component
public class ProductosDAOImplJdbc implements IProductosDAO{

	@Override
	public List<ProductosDTO> buscarProducto(String idProducto, String nombre, String descripcion, Double precio,
			Integer cantidadStock, String idCategorias, String idProveedores)
			throws ClassNotFoundException, SQLException, NamingException {
		String sql = "select p.ID_Producto, p.Nombre, p.Descripcion, p.Precio, p.CantidadEnStock,p.ID_Categoria, c.Nombre, p.ID_Proveedor, pr.Nombre  "
				+ "from productos p inner join categorias c on p.ID_Categoria=c.ID_Categoria "
				+ "inner join proveedores pr on p.ID_Proveedor=pr.ID_Proveedor "
				+ "where p.ID_Producto like ? and p.Nombre like ? and p.Descripcion like ? "
				+ "and p.Precio > ? and p.CantidadEnStock > ? and p.ID_Categoria like ? and p.ID_Proveedor like ?;";
		
		Connection connection = DBUtils.conectaBBDD();
		
		List<ProductosDTO> listaProductos = new ArrayList<ProductosDTO>();
		
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, "%" + idProducto + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + descripcion + "%");
		ps.setDouble(4, precio);
		ps.setInt(5, cantidadStock);
		ps.setString(6, "%" + idCategorias + "%");
		ps.setString(7, "%" + idProveedores + "%");


		ResultSet rs = ps.executeQuery();
		System.out.println(ps.toString());
		
		while (rs.next()) {
			listaProductos.add(new ProductosDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
		}
		connection.close();
		return listaProductos;
	}

	@Override
	public Integer insertarProducto(String nombre, String descripcion, Double precio,
			Integer cantidadStock, String idCategorias, String idProveedores)
			throws ClassNotFoundException, SQLException, NamingException {
		
		String sql = "insert into productos (Nombre, Descripcion, Precio, CantidadEnStock, ID_Categoria, ID_Proveedor) values (?, ?, ?, ?, ?, ?);";
		
Connection connection = DBUtils.conectaBBDD();
		
		List<ProductosDTO> listaProductos = new ArrayList<ProductosDTO>();
		
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, nombre);
		ps.setString(2, descripcion);
		ps.setDouble(3, precio);
		ps.setInt(4, cantidadStock);
		ps.setString(5, idCategorias);
		ps.setString(6, idProveedores);

		System.out.println(ps.toString());
		
		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}



	@Override
	public Integer actualizarProducto(String idProducto, String nombre, String descripcion,  Double precio,
			Integer cantidadStock, String idCategorias, String idProveedores)
			throws ClassNotFoundException, SQLException, NamingException {

		String sql = "update productos set Nombre = ?, Descripcion = ?, Precio = ?, CantidadEnStock = ?, ID_Categoria = ?, ID_Proveedor = ? where ID_Producto = ?;";

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, nombre);
		ps.setString(2, descripcion);
		ps.setDouble(3, precio);
		ps.setInt(4, cantidadStock);
		ps.setString(5, idCategorias);
		ps.setString(6, idProveedores);
		ps.setString(7, idProducto);
		
		System.out.println(ps.toString());
		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}


}
