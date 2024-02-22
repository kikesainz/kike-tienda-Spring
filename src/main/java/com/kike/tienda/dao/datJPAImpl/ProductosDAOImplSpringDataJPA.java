package com.kike.tienda.dao.datJPAImpl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kike.tienda.dao.IProductosDAO;
import com.kike.tienda.dtos.ProductosDTO;
import com.kike.tienda.entities.CategoriaEntity;
import com.kike.tienda.entities.ProductoEntity;
import com.kike.tienda.entities.ProveedorEntity;
import com.kike.tienda.repositories.CategoriasRepository;
import com.kike.tienda.repositories.ProductoRepository;
import com.kike.tienda.repositories.ProveedoresRepository;

@Component("JPAProductos")
public class ProductosDAOImplSpringDataJPA implements IProductosDAO{

	@Autowired
	ProductoRepository productosRepository;
	@Autowired
	CategoriasRepository categoriaRepository;
	@Autowired
	ProveedoresRepository proveedorRepository;
	@Override
	public List<ProductosDTO> buscarProducto(String idProducto, String nombre, String descripcion, Double precio,
			Integer cantidadStock, String idCategorias, String idProveedores)
			throws ClassNotFoundException, SQLException, NamingException {
		
//		idProducto = idProducto.equals("") ? null : idProducto;
//		idCategorias = idCategorias.equals("") ? null : idCategorias;
//		idProveedores = idProveedores.equals("") ? null : idProveedores;
		
		return productosRepository.buscarProductosporIdyNombre(idProveedores, nombre, descripcion, precio, cantidadStock, idCategorias, idProveedores);
	}

	@Override
	public Integer insertarProducto(String nombre, String descripcion, Double precio, Integer cantidadStock,
			String idCategorias, String idProveedores) throws ClassNotFoundException, SQLException, NamingException {
		CategoriaEntity categoriaEntity = categoriaRepository.findById(idCategorias).get();
		ProveedorEntity proveedorEntity = proveedorRepository.findById(idProveedores).get();
		
		ProductoEntity productoEntity = new ProductoEntity(nombre, descripcion, precio, cantidadStock, categoriaEntity, proveedorEntity);
		
		productosRepository.save(productoEntity);
		return Integer.parseInt(productoEntity.getId());
	}

	@Override
	public Integer actualizarProducto(String idProducto, String nombre, String descripcion, Double precio,
			Integer cantidadStock, String idCategorias, String idProveedores)
			throws ClassNotFoundException, SQLException, NamingException {
		CategoriaEntity categoriaEntity = categoriaRepository.findById(idCategorias).get();
		ProveedorEntity proveedorEntity = proveedorRepository.findById(idProveedores).get();
		
		ProductoEntity productoEntity = new ProductoEntity(idProducto, nombre, descripcion, precio, cantidadStock, categoriaEntity, proveedorEntity);
		
		productosRepository.save(productoEntity);
		return Integer.parseInt(productoEntity.getId());
	}

}
