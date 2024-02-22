package com.kike.tienda.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.kike.tienda.dao.IPeticionesDAO;
import com.kike.tienda.dtos.PeticionesDTO;

@Component
public class PeticionesService implements IPeticionesService{

	@Autowired
	@Qualifier("JPAPeticiones")
	IPeticionesDAO peticionesService;
	@Override
	public List<PeticionesDTO> buscarPeticiones(String idPeticion, String idCliente, String idProducto, String cantidad,
			String idEstado, String fechaPedido) throws ClassNotFoundException, SQLException, NamingException {
		
		return peticionesService.buscarPeticiones(idPeticion, idCliente, idProducto, cantidad, idEstado, fechaPedido);
	}
	@Override
	public Integer insertarPeticiones(String idCliente, String idProducto, String cantidad, String idEstado
			) throws ClassNotFoundException, SQLException, NamingException {
	
		return peticionesService.insertarPeticiones(idCliente, idProducto, cantidad, idEstado);
	}
	@Override
	public Integer modificarPeticiones(String idPeticion, String idCliente, String idProducto, String cantidad,
			String idEstado, String fechaPedido) throws ClassNotFoundException, SQLException, NamingException {

		return peticionesService.modificarPeticiones(idPeticion, idCliente, idProducto, cantidad, idEstado, fechaPedido);
	}
	@Override
	public List<PeticionesDTO> buscarPeticionesParaModificar(String idPeticion, String idCliente, String idProducto,
			String cantidad, String idEstado, String fechaPedido)
			throws ClassNotFoundException, SQLException, NamingException {
		
		return peticionesService.buscarPeticionesParaModificar(idPeticion, idCliente, idProducto, cantidad, idEstado, fechaPedido);
	}
	@Override
	public Integer borrarPeticiones(String idPeticion) throws ClassNotFoundException, SQLException, NamingException {
		
		return peticionesService.borrarPeticiones(idPeticion);
	}
	

}
