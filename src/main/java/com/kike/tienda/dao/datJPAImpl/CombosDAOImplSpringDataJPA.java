package com.kike.tienda.dao.datJPAImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kike.tienda.dao.IComboDAO;
import com.kike.tienda.dtos.ComboDTO;
import com.kike.tienda.entities.CategoriaEntity;
import com.kike.tienda.entities.ClienteEntity;
import com.kike.tienda.entities.EstadoPedidosEntity;
import com.kike.tienda.entities.PoblacionEntity;
import com.kike.tienda.entities.ProductoEntity;
import com.kike.tienda.entities.ProveedorEntity;
import com.kike.tienda.repositories.CategoriasRepository;
import com.kike.tienda.repositories.ClientesRepository;
import com.kike.tienda.repositories.EstadoRepository;
import com.kike.tienda.repositories.PedidoRepository;
import com.kike.tienda.repositories.PoblacionRepository;
import com.kike.tienda.repositories.ProductoRepository;
import com.kike.tienda.repositories.ProveedoresRepository;

@Service
public class CombosDAOImplSpringDataJPA implements IComboDAO{

	@Autowired 
	private ProveedoresRepository proveedoresRepository;
	@Autowired 
	private CategoriasRepository categoriasRepository;
	@Autowired 
	private PoblacionRepository poblacionRepository;
	@Autowired 
	private ClientesRepository clientesRepository;
	@Autowired 
	private EstadoRepository estadoRepository;
	@Autowired 
	private ProductoRepository productosRepository;

	private List<ComboDTO> mapeoEntidadProveedoresComboDTO(Iterable<ProveedorEntity> listaEntidadesProveedores){
		List<ComboDTO> listaCombos = new ArrayList<>();
		for(ProveedorEntity proveedorEntity : listaEntidadesProveedores) {
			listaCombos.add(new ComboDTO(Integer.parseInt(proveedorEntity.getId()), proveedorEntity.getNombre()));
		}
		return listaCombos;
	}
	
	@Override
	public List<ComboDTO> recuperarListaProveedores() throws ClassNotFoundException, SQLException, NamingException {
		
		Iterable<ProveedorEntity> listaEntidadesProveedor = proveedoresRepository.findAll();
		
		return mapeoEntidadProveedoresComboDTO(listaEntidadesProveedor);
	}

	private List<ComboDTO> mapeoEntidadCategoriasComboDTO(Iterable<CategoriaEntity> listaEntidadesCategoria){
		List<ComboDTO> listaCombos = new ArrayList<>();
		for(CategoriaEntity categoriaEntity : listaEntidadesCategoria) {
			listaCombos.add(new ComboDTO(Integer.parseInt(categoriaEntity.getId()), categoriaEntity.getNombre()));

		}
		return listaCombos;
	}
	@Override
	public List<ComboDTO> reuperarListaCategorias() throws ClassNotFoundException, SQLException, NamingException {
		
		Iterable<CategoriaEntity> listaEntidadesCategoria = categoriasRepository.findAll();
		return mapeoEntidadCategoriasComboDTO(listaEntidadesCategoria);
	}

	private List<ComboDTO> mapeoEntidadPoblacionComboDTO(Iterable<PoblacionEntity> listaEntidadesPoblacion){
		List<ComboDTO> listaCombos = new ArrayList<>();
		for(PoblacionEntity poblacionEntity : listaEntidadesPoblacion) {
			listaCombos.add(new ComboDTO(Integer.parseInt(poblacionEntity.getId()) , poblacionEntity.getNombre()));
		}
		return listaCombos;
	}
	@Override
	public List<ComboDTO> recuperarListaPoblacion() throws ClassNotFoundException, SQLException, NamingException {
		Iterable<PoblacionEntity> listaEntidadesPoblacion = poblacionRepository.findAll();
		return mapeoEntidadPoblacionComboDTO(listaEntidadesPoblacion);
		}

	private List<ComboDTO> mapeoEntidadClientesComboDTO(Iterable<ClienteEntity> listaEntidadesClientes){
		List<ComboDTO> listaCombos = new ArrayList<>();
		for(ClienteEntity clientesEntity : listaEntidadesClientes) {
			listaCombos.add(new ComboDTO(Integer.parseInt(clientesEntity.getId()), clientesEntity.getNombre()));
		}
		return listaCombos;
	}
	@Override
	public List<ComboDTO> recuperarListaClientes() throws ClassNotFoundException, SQLException, NamingException {
		Iterable<ClienteEntity> listaEntidadesClientes = clientesRepository.findAll();
		return mapeoEntidadClientesComboDTO(listaEntidadesClientes);
	}

	private List<ComboDTO> mapeoEntidadEstadosComboDTO(Iterable<EstadoPedidosEntity> listaEntidadesEstados){
		List<ComboDTO> listaCombos = new ArrayList<>();
		for(EstadoPedidosEntity estadoEntity : listaEntidadesEstados) {
			listaCombos.add(new ComboDTO(Integer.parseInt(estadoEntity.getId()), estadoEntity.getEstado()));
		}
		return listaCombos;
	}
	@Override
	public List<ComboDTO> recuperarListaEstados() throws ClassNotFoundException, SQLException, NamingException {
		Iterable<EstadoPedidosEntity> listaEntidadesEstados = estadoRepository.findAll();
		return mapeoEntidadEstadosComboDTO(listaEntidadesEstados);
	}

	private List<ComboDTO> mapeoEntidadProductosComboDTO(Iterable<ProductoEntity> listaEntidadesProductos){
		List<ComboDTO> listaCombos = new ArrayList<>();
		for(ProductoEntity productosEntity : listaEntidadesProductos) {
			listaCombos.add(new ComboDTO(Integer.parseInt(productosEntity.getId()) , productosEntity.getNombre()));
		}
		return listaCombos;
	}
	@Override
	public List<ComboDTO> recuperarListaProductos() throws ClassNotFoundException, SQLException, NamingException {
		Iterable<ProductoEntity> listaEntidadesProductos = productosRepository.findAll();
		return mapeoEntidadProductosComboDTO(listaEntidadesProductos);
	}

}
