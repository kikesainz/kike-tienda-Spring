package com.kike.tienda.dtos;

public class ProveedoresDTO {

	private String idProveedor;
	private String nombre;
	private String contacto;
	private String telefono;
	private String correoElectronico;
	private String direccion;
	private Integer activo;
	
	public ProveedoresDTO() {
		super();
	}



	public ProveedoresDTO(String idProveedor, String nombre, String contacto, String telefono,
			String correoElectronico, String direccion, Integer activo) {
		super();
		this.idProveedor = idProveedor;
		this.nombre = nombre;
		this.contacto = contacto;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.direccion = direccion;
		this.activo = activo;
	}


	public String getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Integer getActivo() {
		return activo;
	}
	public void setActivo(Integer activo) {
		this.activo = activo;
	}


	public String getCorreoElectronico() {
		return correoElectronico;
	}


	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	
	
}
