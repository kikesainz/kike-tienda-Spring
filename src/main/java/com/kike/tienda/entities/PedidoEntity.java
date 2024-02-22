package com.kike.tienda.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class PedidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Pedido")
	private String id;

	@ManyToOne
	@JoinColumn(name = "ID_Cliente")
	@JsonBackReference
	private ClienteEntity cliente;

	@Column(name = "FechaPedido")
	private String fechaPedido;

	@ManyToOne
	@JoinColumn(name = "EstadoID")
	@JsonBackReference
	private EstadoPedidosEntity estado;

	@OneToMany(mappedBy = "pedido")
	@JsonManagedReference
	private Set<DetallePedidoEntity> detallePedidos;

	
	public PedidoEntity(ClienteEntity cliente) {
		super();
		this.cliente = cliente;
	}

	public PedidoEntity(ClienteEntity cliente, EstadoPedidosEntity estado) {
		super();
		this.cliente = cliente;
		this.estado = estado;
	}

	public PedidoEntity(String id, EstadoPedidosEntity estado) {
		super();
		this.id = id;
		this.estado = estado;
	}

	public PedidoEntity(String id, ClienteEntity cliente) {
		super();
		this.id = id;
		this.cliente = cliente;
	}

	public PedidoEntity(String id, ClienteEntity cliente, String fechaPedido, EstadoPedidosEntity estado) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.fechaPedido = fechaPedido;
		this.estado = estado;
	}

	public PedidoEntity() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public String getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public EstadoPedidosEntity getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedidosEntity estado) {
		this.estado = estado;
	}

	public Set<DetallePedidoEntity> getDetallePedidos() {
		return detallePedidos;
	}

	public void setDetallePedidos(Set<DetallePedidoEntity> detallePedidos) {
		this.detallePedidos = detallePedidos;
	}

}
