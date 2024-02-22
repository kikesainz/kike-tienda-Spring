package com.kike.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.kike.tienda.dtos.ClientesDTO;
import com.kike.tienda.entities.ClienteEntity;

public interface ClientesRepository extends CrudRepository<ClienteEntity, String>{

	@Query(value="select new com.kike.tienda.dtos.ClientesDTO (c.id, c.nombre, c.correoElectronico, p.id, p.nombre, c.activo) "
			+ " from com.kike.tienda.entities.ClienteEntity c "
			+ " inner join com.kike.tienda.entities.PoblacionEntity p on c.poblacion.id = p.id "
			+ " where c.id like CONCAT ('%',:id,'%') "
			+ " and c.nombre like CONCAT ('%',:nombre,'%') "
			+ " and c.correoElectronico like CONCAT ('%',:correoElectronico,'%') "
			+ " AND p.id like CONCAT ('%',:poblacion,'%') "
			+ " AND c.activo = :activo ")
	List<ClientesDTO>buscarClientesporIdNombre(@Param("id") String id,
			@Param("nombre") String nombre,
			@Param("correoElectronico") String correoElectronico,
			@Param("poblacion") String poblacion,
			@Param("activo") Integer activo);
}
