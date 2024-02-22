package com.kike.tienda.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalles_pedido")
public class DetallePedidoEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Detalle")
    private String id;
	
	@ManyToOne
    @JoinColumn(name = "ID_Pedido")
	@JsonBackReference
    private PedidoEntity pedido;
	
	@OneToOne
	@JoinColumn(name="ID_Producto")
	@JsonBackReference
	private ProductoEntity producto;
	
    @Column(name = "Cantidad")
    private Integer cantidad;
    
    @Column(name = "PrecioUnitario")
    private Double precio;

	public DetallePedidoEntity() {
		super();
	}

	
	
	public DetallePedidoEntity(ProductoEntity producto, Integer cantidad, Double precio) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}



	public DetallePedidoEntity(PedidoEntity pedido, ProductoEntity producto, Integer cantidad, Double precio) {
		super();
		this.pedido = pedido;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}


	public DetallePedidoEntity(String id, ProductoEntity producto, Integer cantidad, Double precio) {
		super();
		this.id = id;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}


	public DetallePedidoEntity(String id, PedidoEntity pedido, ProductoEntity producto, Integer cantidad,
			Double precio) {
		super();
		this.id = id;
		this.pedido = pedido;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}

	public ProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
    
    
}
