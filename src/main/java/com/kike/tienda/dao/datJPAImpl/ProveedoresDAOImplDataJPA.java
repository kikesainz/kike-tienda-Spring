package com.kike.tienda.dao.datJPAImpl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kike.tienda.dao.IProveedoresDAO;
import com.kike.tienda.dtos.ProveedoresDTO;
import com.kike.tienda.entities.ProveedorEntity;
import com.kike.tienda.repositories.ProveedoresRepository;

@Component("JPAProveedores")
public class ProveedoresDAOImplDataJPA implements IProveedoresDAO{

	@Autowired
	ProveedoresRepository proveedorRepository;
	@Override
	public List<ProveedoresDTO> buscarProveedor(String idProveedor, String nombre, String contacto, String telefono,
			String correoElectronico, String direccion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		

		return proveedorRepository.buscarProveedoresPorIdyNombre(idProveedor, nombre, contacto, telefono, correoElectronico, direccion, Integer.parseInt(activo));
	}

	@Override
	public Integer insertarProveedor(String idProveedor, String nombre, String contacto, String telefono,
			String correoElectronico, String direccion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		
		ProveedorEntity proveedorEntity = new ProveedorEntity(nombre, contacto, telefono, correoElectronico, direccion, Integer.parseInt(activo));
		proveedorRepository.save(proveedorEntity);
		return Integer.parseInt(proveedorEntity.getId());
	}

	@Override
	public Integer actualizarProvedor(String idProveedor, String nombre, String contacto, String telefono,
			String correoElectronico, String direccion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {

		ProveedorEntity proveedorEntity = new ProveedorEntity(idProveedor, nombre, contacto, telefono, correoElectronico, direccion, Integer.parseInt(activo));
		proveedorRepository.save(proveedorEntity);
		return Integer.parseInt(proveedorEntity.getId());
	}

}
