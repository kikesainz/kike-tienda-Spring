package com.kike.tienda.dtos;

public class ProductosDTO {

	private String idProducto;
	private String nombre;
	private String descripcion;
	private Double precio;
	private Integer cantidadStock;
	private String idCategroria;
	private String nombreCategoria;
	private String idProveedor;
	private String nombreProveedor;
	
	
	public ProductosDTO() {
		super();
	}

	


	public ProductosDTO(String id, String nombre, String descripcion, Double precio, Integer cantidadStock,
			String idCategroria, String idProveedor) {
		super();
		this.idProducto = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidadStock = cantidadStock;
		this.idCategroria = idCategroria;
		this.idProveedor = idProveedor;
	}

	
	


	public ProductosDTO(String idProducto, String nombre, String descripcion, Double precio, Integer cantidadStock,
			String idCategroria, String nombreCategoria, String idProveedor, String nombreProveedor) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidadStock = cantidadStock;
		this.idCategroria = idCategroria;
		this.nombreCategoria = nombreCategoria;
		this.idProveedor = idProveedor;
		this.nombreProveedor = nombreProveedor;
	}


	public String getId() {
		return idProducto;
	}


	public void setId(String id) {
		this.idProducto = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	public Integer getCantidadStock() {
		return cantidadStock;
	}


	public void setCantidadStock(Integer cantidadStock) {
		this.cantidadStock = cantidadStock;
	}


	public String getIdCategroria() {
		return idCategroria;
	}


	public void setIdCategroria(String idCategroria) {
		this.idCategroria = idCategroria;
	}


	public String getIdProveedor() {
		return idProveedor;
	}


	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}


	public String getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}


	public String getNombreCategoria() {
		return nombreCategoria;
	}


	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}


	public String getNombreProveedor() {
		return nombreProveedor;
	}


	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}




	


	
	
}
