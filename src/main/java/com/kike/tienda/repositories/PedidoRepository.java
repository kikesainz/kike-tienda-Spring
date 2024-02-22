package com.kike.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.kike.tienda.dtos.PedidosDTO;
import com.kike.tienda.entities.PedidoEntity;

public interface PedidoRepository extends CrudRepository<PedidoEntity, String>{

	@Query(value="select new com.kike.tienda.dtos.PedidosDTO (p.id, c.id, c.nombre, pr.id, pr.nombre, d.cantidad, d.precio) "
			+ " from com.kike.tienda.entities.PedidoEntity p "
			+ " inner join com.kike.tienda.entities.ClienteEntity c on p.cliente.id = c.id "
			+ " inner join com.kike.tienda.entities.DetallePedidoEntity d on p.id = d.pedido.id "
			+ " inner join com.kike.tienda.entities.ProductoEntity pr on d.producto.id = pr.id "
			+ " inner join com.kike.tienda.entities.EstadoPedidosEntity e on p.estado.id = e.id "
			+ " where p.id like CONCAT ('%',:id,'%') "
			+ " and c.id like CONCAT ('%',:cliente,'%') "
			+ " and p.fechaPedido like CONCAT ('%',:fechaPedido,'%') "
			+ " and e.id like CONCAT ('%',:estado,'%') ")
	List<PedidosDTO>buscarPedidos(@Param("id") String id,
			@Param("cliente") String cliente,
			@Param("fechaPedido") String fechaPedido,
			@Param("estado") String estado);
	
	@Query(value="select new com.kike.tienda.dtos.ItemDTO (sum(d.precio)) "
			+ " from com.kike.tienda.entities.ClienteEntity c "
			+ " inner join com.kike.tienda.entities.PedidoEntity p on p.cliente.id = c.id "
			+ " inner join com.kike.tienda.entities.DetallePedidoEntity d on p.id = d.pedido.id "
			+ " where c.id = :cliente ")
	Double buscarPrecioAcumulado(@Param("cliente") Integer cliente);
	
	@Query(value="select new com.kike.tienda.dtos.DescuentosDTO (d.descuento) "
			+ " from com.kike.tienda.entities.DescuentoEntity d "
			+ " where d.cantidad >= :precioAcumulado ")
	Double buscarDescuento(@Param("precioAcumulad") Double precioAcumulad);
	
	@Query(value="select new com.kike.tienda.dtos.ProductosDTO (p.precio) "
			+ " from com.kike.tienda.entities.ProductoEntity p "
			+ " where p.id = :producto")
	Double buscarPrecioProducto(@Param("producto") Integer producto);
}
