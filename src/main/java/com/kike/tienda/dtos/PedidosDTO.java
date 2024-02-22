package com.kike.tienda.dtos;

public class PedidosDTO {

	private String idPedido;
	private String idCliente;
	private String nombreCliente;
	private String idProducto;
	private String nombreProducto;
	private Integer cantidad;
	private Double precio;
	private String fechaPedido;
	private Integer idEstado;
	private String nombreEstado;
	private Integer idDetallePedido;
	
	public PedidosDTO() {
		super();
	}




	public PedidosDTO(String idPedido, String idCliente, String nombreCliente, String idProducto, String nombreProducto,
			Integer cantidad, Double precio) {
		super();
		this.idPedido = idPedido;
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
		this.precio = precio;
	}




	public PedidosDTO(String idPedido, String idCliente, String nombreCliente, String idProducto,
			String nombreProducto, Integer cantidad, Double precio, Integer idDetallePedido) {

		super();
		this.idPedido = idPedido;
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.idDetallePedido = idDetallePedido;
	}

	public PedidosDTO(String idPedido, String nombreCliente, String nombreProducto, Integer cantidad, Double precio) {
		super();
		this.idPedido = idPedido;
		this.nombreCliente = nombreCliente;
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	

	public PedidosDTO(String nombreCliente, String nombreProducto, Integer cantidad, Double precio) {
		super();
		this.nombreCliente = nombreCliente;
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public String getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getNombreEstado() {
		return nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
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



	public Double getPrecio() {
		return precio;
	}



	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getIdDetallePedido() {
		return idDetallePedido;
	}

	public void setIdDetallePedido(Integer idDetallePedido) {
		this.idDetallePedido = idDetallePedido;
	}
	
	
}
