package com.kike.tienda.entities;


import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "clientes")
public class ClienteEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Cliente")
    private String id;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "CorreoElectronico", nullable = false, unique = true)
    private String correoElectronico;

    @Column(name = "password")
    private String password;

    @Column(name = "FechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "ID_Poblacion")
    private PoblacionEntity poblacion;

    @Column(name = "activo")
    private Integer activo;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private Set<PedidoEntity> pedidos;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private Set<PeticionesEntity> peticiones;



	public ClienteEntity(String id, String nombre, String correoElectronico, String password, Date fechaRegistro,
			PoblacionEntity poblacion, Integer activo, Set<PedidoEntity> pedidos, Set<PeticionesEntity> peticiones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.password = password;
		this.fechaRegistro = fechaRegistro;
		this.poblacion = poblacion;
		this.activo = activo;
		this.pedidos = pedidos;
		this.peticiones = peticiones;
	}

	public ClienteEntity(String nombre, String correoElectronico, PoblacionEntity poblacion, Integer activo) {
		super();
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.poblacion = poblacion;
		this.activo = activo;
	}

	public ClienteEntity(String id) {
		super();
		this.id = id;
	}

	public ClienteEntity(String id, String nombre, String correoElectronico, PoblacionEntity poblacion, Integer activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.poblacion = poblacion;
		this.activo = activo;
	}





	public PoblacionEntity getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(PoblacionEntity poblacion) {
		this.poblacion = poblacion;
	}

	public ClienteEntity() {
		super();
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

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	public Set<PedidoEntity> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<PedidoEntity> pedidos) {
		this.pedidos = pedidos;
	}

	public Set<PeticionesEntity> getPeticiones() {
		return peticiones;
	}

	public void setPeticiones(Set<PeticionesEntity> peticiones) {
		this.peticiones = peticiones;
	}





    // Getters y setters...
    
    
}

