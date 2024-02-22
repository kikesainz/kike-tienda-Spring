package com.kike.tienda.dao.datJPAImpl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kike.tienda.dao.IClientesDAO;
import com.kike.tienda.dtos.ClientesDTO;
import com.kike.tienda.entities.ClienteEntity;
import com.kike.tienda.entities.PoblacionEntity;
import com.kike.tienda.repositories.ClientesRepository;
import com.kike.tienda.repositories.PoblacionRepository;

@Component("JPAClientes")
public class ClientesDAOImplDataJPA implements IClientesDAO{
	@Autowired
	ClientesRepository clientesRepository;
	@Autowired
	PoblacionRepository poblacionRepository;
	@Override
	public List<ClientesDTO> buscarClientes(String idClientes, String nombre, String correoElectronico,
			String idPoblacion, String activo) throws ClassNotFoundException, SQLException, NamingException {
		

		return clientesRepository.buscarClientesporIdNombre(idClientes, nombre, correoElectronico, idPoblacion, Integer.parseInt(activo));
	}

	@Override
	public Integer insertarClientes(String nombre, String correoElectronico, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		
		PoblacionEntity poblacionEntity = poblacionRepository.findById(idPoblacion).get();
		ClienteEntity clientesEntity = new ClienteEntity(nombre, correoElectronico, poblacionEntity, Integer.parseInt(activo));
		clientesRepository.save(clientesEntity);
		return Integer.parseInt(clientesEntity.getId());
	}

	@Override
	public Integer actualizarClientes(String idClientes, String nombre, String correoElectronico, String idPoblacion,
			String activo) throws ClassNotFoundException, SQLException, NamingException {

		PoblacionEntity poblacionEntity = poblacionRepository.findById(idPoblacion).get();
		ClienteEntity clientesEntity = new ClienteEntity(idClientes, nombre, correoElectronico, poblacionEntity, Integer.parseInt(activo));
		clientesRepository.save(clientesEntity);
		return Integer.parseInt(clientesEntity.getId());
	}

	@Override
	public Integer borrarClientes(String idClientes) throws ClassNotFoundException, SQLException, NamingException {
		
		ClienteEntity clientesEntity = clientesRepository.findById(idClientes).get();
		clientesEntity.setActivo(0);
		clientesRepository.save(clientesEntity);
		return Integer.parseInt(clientesEntity.getId());
	}

}
