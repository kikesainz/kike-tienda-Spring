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
import jakarta.persistence.Table;

@Entity
@Table(name = "peticiones")
public class PeticionesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_Peticiones")
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "ID_Cliente")
    @JsonManagedReference
    private ClienteEntity cliente;
    
    @ManyToOne
    @JoinColumn(name="ID_Producto")
    @JsonManagedReference
    private ProductoEntity producto;
    
    @Column(name="FechaAñadido")
    private String fecha;
    
    @Column(name="cantidad")
    private Integer cantidad;
    

    
	public PeticionesEntity() {
		super();
	}





	public PeticionesEntity(String id, ClienteEntity cliente, ProductoEntity producto, String fecha) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.producto = producto;
		this.fecha = fecha;
	}





	public PeticionesEntity(String id, ClienteEntity cliente, ProductoEntity producto, String fecha,
			Integer cantidad) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.producto = producto;
		this.fecha = fecha;
		this.cantidad = cantidad;
	}




	public PeticionesEntity(ClienteEntity cliente, ProductoEntity producto, Integer cantidad) {
		super();
		this.cliente = cliente;
		this.producto = producto;
		this.cantidad = cantidad;

	}





	public PeticionesEntity(String id, ClienteEntity cliente, ProductoEntity producto, Integer cantidad) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.producto = producto;
		this.cantidad = cantidad;
	}




	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public ProductoEntity getProducto() {
		return producto;
	}


	public void setProducto(ProductoEntity producto) {
		this.producto = producto;
	}


	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}




    
    
    
}
