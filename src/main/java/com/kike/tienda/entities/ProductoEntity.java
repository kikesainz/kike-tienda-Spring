package com.kike.tienda.entities;


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

@Entity
@Table(name = "productos")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Producto")
    private String id;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Precio")
    private Double precio;

    @Column(name = "CantidadEnStock")
    private Integer cantidadEnStock;

    @ManyToOne
    @JoinColumn(name = "ID_Categoria")
    private CategoriaEntity categoria;
    
    @ManyToOne
    @JoinColumn(name = "ID_Proveedor")
    private ProveedorEntity proveedor;

    @OneToMany(mappedBy = "producto")
    @JsonIgnore
    private Set<PeticionesEntity> peticiones;
    
    
    @OneToMany(mappedBy = "producto")
    @JsonIgnore
    private Set<DetallePedidoEntity> detallePedidos;
    
    






	public ProductoEntity(Integer cantidadEnStock) {
		super();
		this.cantidadEnStock = cantidadEnStock;
	}

	public ProductoEntity(String id, String nombre, String descripcion, Double precio, Integer cantidadEnStock,
			CategoriaEntity categoria, ProveedorEntity proveedor, Set<PeticionesEntity> peticiones,
			Set<DetallePedidoEntity> detallePedidos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidadEnStock = cantidadEnStock;
		this.categoria = categoria;
		this.proveedor = proveedor;
		this.peticiones = peticiones;
		this.detallePedidos = detallePedidos;
	}

	public ProductoEntity() {
		super();
	}

	public ProductoEntity(String id, Integer cantidadEnStock) {
		super();
		this.id = id;
		this.cantidadEnStock = cantidadEnStock;
	}

	public ProductoEntity(String id) {
		super();
		this.id = id;
	}

	public ProductoEntity(String id, String nombre, String descripcion, Double precio, Integer cantidadEnStock,
			CategoriaEntity categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidadEnStock = cantidadEnStock;
		this.categoria = categoria;
	}

	
	
	public ProductoEntity(String id, String nombre, String descripcion, Double precio, Integer cantidadEnStock,
			CategoriaEntity categoria, ProveedorEntity proveedor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidadEnStock = cantidadEnStock;
		this.categoria = categoria;
		this.proveedor = proveedor;
	}

	public ProductoEntity(String nombre, String descripcion, Double precio, Integer cantidadEnStock,
			CategoriaEntity categoria, ProveedorEntity proveedor) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidadEnStock = cantidadEnStock;
		this.categoria = categoria;
		this.proveedor = proveedor;
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidadEnStock() {
		return cantidadEnStock;
	}

	public void setCantidadEnStock(Integer cantidadEnStock) {
		this.cantidadEnStock = cantidadEnStock;
	}

	public CategoriaEntity getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEntity categoria) {
		this.categoria = categoria;
	}

	public ProveedorEntity getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorEntity proveedor) {
		this.proveedor = proveedor;
	}



	public Set<PeticionesEntity> getPeticiones() {
		return peticiones;
	}

	public void setPeticiones(Set<PeticionesEntity> peticiones) {
		this.peticiones = peticiones;
	}

	public Set<DetallePedidoEntity> getDetallePedidos() {
		return detallePedidos;
	}

	public void setDetallePedidos(Set<DetallePedidoEntity> detallePedidos) {
		this.detallePedidos = detallePedidos;
	}
    
    
}
