package com.kike.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.kike.tienda.dtos.CategoriasDTO;
import com.kike.tienda.entities.CategoriaEntity;

public interface CategoriasRepository extends CrudRepository<CategoriaEntity, String>{

	@Query(value= "select new com.kike.tienda.dtos.CategoriasDTO (c.id, c.nombre, c.descripcion, c.activo) "
			+ " from com.kike.tienda.entities.CategoriaEntity c "
			+ " where  c.id like CONCAT ('%',:id,'%') "
			+ " and c.nombre like CONCAT ('%',:nombre,'%') "
			+ " and c.descripcion like CONCAT ('%',:descripcion,'%') "
			+ " AND c.activo = :activo ")
	List<CategoriasDTO>buscarCategoriasporIDyNombre(@Param("id") String id,
			@Param("nombre") String nombre,
			@Param("descripcion") String descripcion,
			@Param("activo") Integer activo);
	
	@Query(value="select new com.kike.tienda.dtos.CategoriasDTO (c.id, c.nombre) "
			+ " from com.kike.tienda.entities.CategoriaEntity c ")
	List<CategoriasDTO>buscarCategoriasParaCombo(@Param("id") Integer id,
			@Param("nombre") String nombre);
	
}
