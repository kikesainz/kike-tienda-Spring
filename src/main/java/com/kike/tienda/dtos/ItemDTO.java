package com.kike.tienda.dtos;

public class ItemDTO {

	private Integer clienteID;
	private String clienteNombre;
	private Integer productoID;
	private String productoNombre;
	private Integer cantidad;
	private Double precio;
	
	public ItemDTO() {
		super();
	}
	
	
	public ItemDTO(Double precio) {
		super();
		this.precio = precio;
	}


	public ItemDTO(Integer clienteID, String clienteNombre, Integer productoID, String productoNombre, Integer cantidad,
			Double precio) {
		super();
		this.clienteID = clienteID;
		this.clienteNombre = clienteNombre;
		this.productoID = productoID;
		this.productoNombre = productoNombre;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
	public Integer getClienteID() {
		return clienteID;
	}
	public void setClienteID(Integer clienteID) {
		this.clienteID = clienteID;
	}
	public String getClienteNombre() {
		return clienteNombre;
	}
	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}
	public Integer getProductoID() {
		return productoID;
	}
	public void setProductoID(Integer productoID) {
		this.productoID = productoID;
	}
	public String getProductoNombre() {
		return productoNombre;
	}
	public void setProductoNombre(String productoNombre) {
		this.productoNombre = productoNombre;
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
