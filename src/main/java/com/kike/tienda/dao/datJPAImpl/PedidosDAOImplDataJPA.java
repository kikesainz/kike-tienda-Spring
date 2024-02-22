package com.kike.tienda.dao.datJPAImpl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kike.tienda.dao.IPedidosDAO;
import com.kike.tienda.dtos.ItemDTO;
import com.kike.tienda.dtos.PedidosDTO;
import com.kike.tienda.entities.ClienteEntity;
import com.kike.tienda.entities.DetallePedidoEntity;
import com.kike.tienda.entities.EstadoPedidosEntity;
import com.kike.tienda.entities.PedidoEntity;
import com.kike.tienda.entities.ProductoEntity;
import com.kike.tienda.repositories.ClientesRepository;
import com.kike.tienda.repositories.DetallePedidoRepository;
import com.kike.tienda.repositories.EstadoRepository;
import com.kike.tienda.repositories.PedidoRepository;
import com.kike.tienda.repositories.ProductoRepository;

@Component("JPAPedidos")
public class PedidosDAOImplDataJPA implements IPedidosDAO {

	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	ClientesRepository clienteRepository;
	@Autowired
	EstadoRepository estadoRepository;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	DetallePedidoRepository detarllePedidoRepository;
	
	@Override
	public List<PedidosDTO> buscarPedidos(String idPedido, String idCliente, String fechaPedido, String idEstado)
			throws ClassNotFoundException, SQLException, NamingException {

		
		return pedidoRepository.buscarPedidos(idPedido, idCliente, fechaPedido, idEstado);
	}

	@Override
	public List<PedidosDTO> buscarPedidosModificar(String idPedido, String idCliente, String fechaPedido,
			String idEstado) throws ClassNotFoundException, SQLException, NamingException {
		
		return pedidoRepository.buscarPedidos(idPedido, idCliente, fechaPedido, idEstado);
	}

	@Override
	public Integer insertarPedidos(List<ItemDTO> lista) throws ClassNotFoundException, SQLException, NamingException {
		
		String clienteID = "";
		Integer filasInsertadas = 0;
		Integer resultado = 0;
		Integer idProducto = 0;
		Integer cantidad = 0;
		Double precio = 0.0;
		String idEstado = "1";
		String idPedido = "";
		for (ItemDTO i : lista) {
			Integer idCliente = i.getClienteID();
			clienteID = idCliente + "";	
		}
		
		for (ItemDTO i : lista) {
			idProducto = i.getProductoID();
			cantidad = i.getCantidad();
			precio = i.getPrecio();
			ClienteEntity clienteEntity = clienteRepository.findById(clienteID).get();
			EstadoPedidosEntity estadoEntity = estadoRepository.findById(idEstado).get();
			PedidoEntity pedidoEntity = new PedidoEntity(clienteEntity, estadoEntity);
			pedidoRepository.save(pedidoEntity);
			idPedido = pedidoEntity.getId();
			
			ProductoEntity productoEntity = productoRepository.findById(Integer.toString(idProducto)).get();
			DetallePedidoEntity detallePedidoEntity = new DetallePedidoEntity(idPedido, productoEntity, cantidad, precio);
			detarllePedidoRepository.save(detallePedidoEntity);
			
			Integer CantidadFinal = (productoEntity.getCantidadEnStock()) - cantidad;
			productoEntity.setCantidadEnStock(CantidadFinal);
			productoRepository.save(productoEntity);
		}
		return Integer.parseInt(idPedido);
	}

	@Override
	public Integer actualizarPedidos(String idCliente, String idPedido, String idProducto, String cantidad,
			String precioUnitario, String idDetalle) throws ClassNotFoundException, SQLException, NamingException {
		ClienteEntity clienteEntity = clienteRepository.findById(idCliente).get();
		ProductoEntity productoEntity = productoRepository.findById(idProducto).get();
		PedidoEntity pedidosEntity = new PedidoEntity(clienteEntity);
		pedidoRepository.save(pedidosEntity);
		
		DetallePedidoEntity detallePedidoEntity = new DetallePedidoEntity(productoEntity, Integer.parseInt(cantidad), Double.parseDouble(precioUnitario));
		detarllePedidoRepository.save(detallePedidoEntity);
		return Integer.parseInt(detallePedidoEntity.getId());
	}

	@Override
	public Double buscarPrecioAcumulado(Integer cliente) throws ClassNotFoundException, SQLException {
		
		return pedidoRepository.buscarPrecioAcumulado(cliente);
	}

	@Override
	public Double buscarDescuento(Double precioAcumulado) throws ClassNotFoundException, SQLException {
		
		return pedidoRepository.buscarDescuento(precioAcumulado);
	}

	@Override
	public Double buscarPrecioProducto(Integer producto) throws ClassNotFoundException, SQLException {
		
		return pedidoRepository.buscarPrecioProducto(producto);
	}

}
