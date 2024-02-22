package com.kike.tienda.entities;

import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "estadospedidos")
public class EstadoPedidosEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EstadoID")
	private String id;

	@Column(name = "NombreEstado")
	private String estado;

	@OneToMany(mappedBy = "estado")
	private Set<PedidoEntity> pedido;

	
	public EstadoPedidosEntity() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Set<PedidoEntity> getPedido() {
		return pedido;
	}

	public void setPedido(Set<PedidoEntity> pedido) {
		this.pedido = pedido;
	}


	
	
}
