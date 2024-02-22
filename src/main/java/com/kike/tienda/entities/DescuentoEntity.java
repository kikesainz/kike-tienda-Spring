package com.kike.tienda.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "descuentos")
public class DescuentoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddescuentos")
	private String id;
	
	@Column(name = "cantidad")
	private Integer cantidad;
	
	@Column(name = "descuento")
	private Integer descuento;

	public DescuentoEntity(String id, Integer cantidad, Integer descuento) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.descuento = descuento;
	}

	public DescuentoEntity() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}
	
	
}
