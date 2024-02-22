package com.kike.tienda.dao.datJPAImpl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kike.tienda.dao.IPeticionesDAO;
import com.kike.tienda.dtos.PeticionesDTO;
import com.kike.tienda.entities.ClienteEntity;
import com.kike.tienda.entities.EstadoPedidosEntity;
import com.kike.tienda.entities.PeticionesEntity;
import com.kike.tienda.entities.ProductoEntity;
import com.kike.tienda.repositories.ClientesRepository;
import com.kike.tienda.repositories.EstadoRepository;
import com.kike.tienda.repositories.PeticionesRepository;
import com.kike.tienda.repositories.ProductoRepository;

@Component("JPAPeticiones")
public class PeticionesDAOImplDataJPA implements IPeticionesDAO{

	@Autowired
	PeticionesRepository peticionesRepository;
	@Autowired 
	ClientesRepository clientesRepository;
	@Autowired
	ProductoRepository productosRepository;
	@Autowired
	EstadoRepository estadoRepository;

	@Override
	public List<PeticionesDTO> buscarPeticiones(String idPeticion, String idCliente, String idProducto, String cantidad,
			String idEstado, String fechaPedido) throws ClassNotFoundException, SQLException, NamingException {
		

		return peticionesRepository.buscarPeticionesporIdyNombre(idPeticion, idCliente, idProducto, fechaPedido, Integer.parseInt(cantidad), idEstado);
		
	}

	@Override
	public Integer insertarPeticiones(String idCliente, String idProducto, String cantidad, String idEstado)
			throws ClassNotFoundException, SQLException, NamingException {
		ClienteEntity clienteEntity = clientesRepository.findById(idCliente).get();
		ProductoEntity productoEntity = productosRepository.findById(idProducto).get();
//		EstadoPedidosEntity estadoEntity = estadoRepository.findById(idEstado).get();
		
		PeticionesEntity peticionesEntity = new PeticionesEntity(clienteEntity, productoEntity, Integer.parseInt(cantidad));
		
		peticionesRepository.save(peticionesEntity);
		return Integer.parseInt(peticionesEntity.getId());
	}

	@Override
	public Integer modificarPeticiones(String idPeticion, String idCliente, String idProducto, String cantidad,
			String idEstado, String fechaPedido) throws ClassNotFoundException, SQLException, NamingException {
		ClienteEntity clienteEntity = clientesRepository.findById(idCliente).get();
		ProductoEntity productoEntity = productosRepository.findById(idProducto).get();
		EstadoPedidosEntity estadoEntity = estadoRepository.findById(idEstado).get();
		
		PeticionesEntity peticionesEntity = new PeticionesEntity(idPeticion, clienteEntity, productoEntity, Integer.parseInt(cantidad));
		
		peticionesRepository.save(peticionesEntity);
		return Integer.parseInt(peticionesEntity.getId());
	}

	@Override
	public List<PeticionesDTO> buscarPeticionesParaModificar(String idPeticion, String idCliente, String idProducto,
			String cantidad, String idEstado, String fechaPedido)
			throws ClassNotFoundException, SQLException, NamingException {

		return peticionesRepository.buscarPeticionesporIdyNombre(idPeticion, idCliente, idProducto, fechaPedido, Integer.parseInt(cantidad), idEstado);
		
	}

	@Override
	public Integer borrarPeticiones(String idPeticion) throws ClassNotFoundException, SQLException, NamingException {
		
		PeticionesEntity peticionesEntity = peticionesRepository.findById(idPeticion).get();
		
		peticionesRepository.save(peticionesEntity);
		
		return Integer.parseInt(peticionesEntity.getId());
	}

}
