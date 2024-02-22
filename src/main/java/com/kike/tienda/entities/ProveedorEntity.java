package com.kike.tienda.entities;



import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedores")
public class ProveedorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Proveedor")
	private String id;

	@Column(name = "Nombre")
	private String nombre;

	@Column(name = "Contacto")
	private String contacto;

	@Column(name = "Telefono")
	private String telefono;

	@Column(name = "CorreoElectronico")
	private String correoElectronico;

	@Column(name = "Direccion")
	private String direccion;

	@Column(name = "Activo")
	private Integer activo;

    @OneToMany(mappedBy = "proveedor")
    @JsonBackReference
    private Set<ProductoEntity> productos;

	public ProveedorEntity() {
		super();
	}



	public ProveedorEntity(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}



	public ProveedorEntity(String id) {
		super();
		this.id = id;
	}



	public ProveedorEntity(String id, String nombre, String contacto, String telefono, String correoElectronico,
			String direccion, Integer activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contacto = contacto;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.direccion = direccion;
		this.activo = activo;
	}



	public ProveedorEntity(String nombre, String contacto, String telefono, String correoElectronico, String direccion,
			Integer activo) {
		super();
		this.nombre = nombre;
		this.contacto = contacto;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.direccion = direccion;
		this.activo = activo;
	}



	public ProveedorEntity(String id, String nombre, String contacto, String telefono, String correoElectronico,
			String direccion, Integer activo, Set<ProductoEntity> productos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contacto = contacto;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.direccion = direccion;
		this.activo = activo;
		this.productos = productos;
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

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
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

	public Set<ProductoEntity> getProductos() {
		return productos;
	}

	public void setProductos(Set<ProductoEntity> productos) {
		this.productos = productos;
	}

	
}
