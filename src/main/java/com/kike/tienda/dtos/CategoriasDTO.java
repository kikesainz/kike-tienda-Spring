package com.kike.tienda.dtos;

public class CategoriasDTO {

	private String id;
	private String nombre;
	private String descripcion;
	private Integer activo;
	
	public CategoriasDTO() {
		super();
	}
	
	

	
	public CategoriasDTO(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}




	public CategoriasDTO(String id, String nombre, String descripcion, Integer activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
	}



	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	
}
