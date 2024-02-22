package com.kike.tienda.dtos;

public class ClientesDTO {

	private String idClientes;
	private String nombre;
	private String correoElectronico;
	private String contrasena;
	private String fechaRegistro;
	private String idPoblacion;
	private String nombreMunicipio;
	private Integer activo;
	
	public ClientesDTO() {
		super();
	}

	
	










	public ClientesDTO(String idClientes, String nombre, String correoElectronico, String idPoblacion) {
		super();
		this.idClientes = idClientes;
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.idPoblacion = idPoblacion;
	}













	public ClientesDTO(String idClientes, String nombre, String correoElectronico, String idPoblacion,
			String nombreMunicipio, Integer activo) {
		super();
		this.idClientes = idClientes;
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.idPoblacion = idPoblacion;
		this.nombreMunicipio = nombreMunicipio;
		this.activo = activo;
	}







	public ClientesDTO(String idClientes, String nombre, String correoElectronico, String idPoblacion,
			Integer activo) {
		super();
		this.idClientes = idClientes;
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.idPoblacion = idPoblacion;
		this.activo = activo;
	}


	public ClientesDTO(String idClientes, String nombre, String correoElectronico, String contrasena,
			String fechaRegistro, String idPoblacion, Integer activo) {
		super();
		this.idClientes = idClientes;
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.contrasena = contrasena;
		this.fechaRegistro = fechaRegistro;
		this.idPoblacion = idPoblacion;
		this.activo = activo;
	}

	public String getIdClientes() {
		return idClientes;
	}

	public void setIdClientes(String idClientes) {
		this.idClientes = idClientes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getIdPoblacion() {
		return idPoblacion;
	}

	public void setIdPoblacion(String idPoblacion) {
		this.idPoblacion = idPoblacion;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}



	public String getNombreMunicipio() {
		return nombreMunicipio;
	}



	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}
	
	
}
