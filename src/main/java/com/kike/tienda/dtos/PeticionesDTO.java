package com.kike.tienda.dtos;

public class PeticionesDTO {

	private String idPeticion;
	private String idCliente;
	private String nombreCliente;
	private String idProducto;
	private String nombreProducto;
	private String fechaPedido;
	private Integer cantidad;
	private Integer idEstado;
	private String estado;

	
	public PeticionesDTO() {
		super();
	}


	public PeticionesDTO(String idPeticion, String idCliente, String nombreCliente, String idProducto,
			String nombreProducto, String fechaPedido, Integer cantidad, Integer idEstado, String estado) {
		super();
		this.idPeticion = idPeticion;
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.fechaPedido = fechaPedido;
		this.cantidad = cantidad;
		this.idEstado = idEstado;
		this.estado = estado;
	}







	public PeticionesDTO(String idPeticion, String idCliente, String nombreCliente, String idProducto,
			String nombreProducto, String fechaPedido) {
		super();
		this.idPeticion = idPeticion;
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.fechaPedido = fechaPedido;
	}


	public PeticionesDTO(String idPeticion, String nombreCliente, String nombreProducto, String fechaPedido) {
		super();
		this.idPeticion = idPeticion;
		this.nombreCliente = nombreCliente;
		this.nombreProducto = nombreProducto;
		this.fechaPedido = fechaPedido;
	}

	public PeticionesDTO(String idPeticion, String idCliente, String nombreCliente, String idProducto,
			String nombreProducto, Integer cantidad, Integer idEstado, String estado, String fechaPedido) {
		super();
		this.idPeticion = idPeticion;
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
		this.idEstado = idEstado;
		this.estado = estado;
		this.fechaPedido = fechaPedido;
	}
	public String getIdPeticion() {
		return idPeticion;
	}
	public void setIdPeticion(String idPeticion) {
		this.idPeticion = idPeticion;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	
	
}
