package com.kike.tienda.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "poblacion")
public class PoblacionEntity {

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "nombre")
	private String nombre;

	@OneToMany(mappedBy = "poblacion")
	@JsonIgnore
	private Set<ClienteEntity> cliente;

	public PoblacionEntity() {
		super();
	}

	public PoblacionEntity(String id, String nombre, Set<ClienteEntity> cliente) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cliente = cliente;
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

	public Set<ClienteEntity> getCliente() {
		return cliente;
	}

	public void setCliente(Set<ClienteEntity> cliente) {
		this.cliente = cliente;
	}

}
