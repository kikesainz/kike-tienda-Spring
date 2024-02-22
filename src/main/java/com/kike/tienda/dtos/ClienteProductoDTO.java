package com.kike.tienda.dtos;

public class ClienteProductoDTO {

	private Integer cliente;
	private Integer producto;
	public ClienteProductoDTO(Integer cliente, Integer producto) {
		super();
		this.cliente = cliente;
		this.producto = producto;
	}
	public Integer getCliente() {
		return cliente;
	}
	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}
	public Integer getProducto() {
		return producto;
	}
	public void setProducto(Integer producto) {
		this.producto = producto;
	}
	
	
}
