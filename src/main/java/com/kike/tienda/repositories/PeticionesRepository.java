package com.kike.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.kike.tienda.dtos.PeticionesDTO;
import com.kike.tienda.entities.PeticionesEntity;

public interface PeticionesRepository extends CrudRepository<PeticionesEntity, String>{

	
	@Query(value="select new com.kike.tienda.dtos.PeticionesDTO (pe.id, c.id, c.nombre, pr.id, pr.nombre, pe.fecha) "
			+ " from com.kike.tienda.entities.PeticionesEntity pe "
			+ " inner join com.kike.tienda.entities.ClienteEntity c on pe.cliente.id = c.id "
			+ " inner join com.kike.tienda.entities.PedidoEntity p on p.cliente.id = c.id "
			+ " inner join com.kike.tienda.entities.EstadoPedidosEntity e on p.estado.id = e.id "
			+ " inner join com.kike.tienda.entities.ProductoEntity pr on pe.producto.id = pr.id "
			+ "	where pe.id like CONCAT ('%',:id,'%') "
			+ " and c.id like CONCAT ('%',:cliente,'%') "
			+ " and pr.id like CONCAT ('%',:producto,'%') "
			+ " and pe.fecha like CONCAT ('%',:fecha,'%') "
			+ " and pe.cantidad >= :cantidad "
			+ " and e.id like CONCAT ('%',:estado,'%') ")
	List<PeticionesDTO>buscarPeticionesporIdyNombre(@Param("id") String id,
			@Param("cliente") String cliente,
			@Param("producto") String producto,
			@Param("fecha") String fecha,
			@Param("cantidad") Integer cantidad,
			@Param("estado") String estado);
}
