package com.kike.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.kike.tienda.dtos.ProveedoresDTO;
import com.kike.tienda.entities.ProveedorEntity;

public interface ProveedoresRepository extends CrudRepository<ProveedorEntity, String>{

	@Query(value="select new com.kike.tienda.dtos.ProveedoresDTO (p.id, p.nombre, p.contacto, p.telefono, p.correoElectronico, p.direccion, p.activo) "
			+ " from com.kike.tienda.entities.ProveedorEntity p "
			+ " where p.id LIKE CONCAT ('%',:id,'%')  "
			+ " and p.nombre LIKE CONCAT ('%',:nombre,'%') "
			+ " and p.contacto LIKE CONCAT ('%',:contacto,'%') "
			+ " and p.telefono LIKE CONCAT ('%',:telefono,'%') "
			+ " and p.correoElectronico LIKE CONCAT ('%',:correoElectronico,'%') "
			+ " and p.direccion LIKE CONCAT ('%',:direccion,'%') "
			+ " and p.activo = :activo ")
	List<ProveedoresDTO>buscarProveedoresPorIdyNombre(@Param("id") String id,
			@Param("nombre") String nombre,
			@Param("contacto") String contacto,
			@Param("telefono") String telefono,
			@Param("correoElectronico") String correoElectronico,
			@Param("direccion") String direccion,
			@Param("activo") Integer activo);
}
