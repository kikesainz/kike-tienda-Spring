package com.kike.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.kike.tienda.dtos.ProductosDTO;
import com.kike.tienda.entities.ProductoEntity;

public interface ProductoRepository extends CrudRepository<ProductoEntity, String>{

	@Query(value = "select new com.kike.tienda.dtos.ProductosDTO (p.id, p.nombre, p.descripcion, p.precio, p.cantidadEnStock, c.id, c.nombre, pr.id, p.nombre) "
			+ " from com.kike.tienda.entities.ProductoEntity p "
			+ " inner join com.kike.tienda.entities.CategoriaEntity c on p.categoria.id = c.id "
			+ " inner join com.kike.tienda.entities.ProveedorEntity pr on p.proveedor.id = pr.id "
			+ " where p.id like CONCAT ('%',:id,'%') "
			+ " and p.nombre like CONCAT ('%',:nombre,'%') "
			+ " and p.descripcion like CONCAT ('%',:descripcion,'%') "
			+ " and p.precio >= :precio "
			+ " and p.cantidadEnStock >= :cantidadEnStock "
			+ " and c.id like CONCAT ('%',:categoria,'%') "
			+ " and pr.id like CONCAT ('%',:proveedor,'%') ")
	List<ProductosDTO>buscarProductosporIdyNombre(@Param("id") String id,
			@Param("nombre") String nombre,
			@Param("descripcion") String descripcion,
			@Param("precio") Double precio,
			@Param("cantidadEnStock") Integer cantidadEnStock,
			@Param("categoria") String categoria,
			@Param("proveedor") String proveedor);
}
