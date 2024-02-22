package com.kike.tienda.dtos;

public class DescuentosDTO {

	private String id;
	private Integer cantidad;
	private Integer descuento;
	public DescuentosDTO(String id, Integer cantidad, Integer descuento) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.descuento = descuento;
	}
	public DescuentosDTO() {
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
