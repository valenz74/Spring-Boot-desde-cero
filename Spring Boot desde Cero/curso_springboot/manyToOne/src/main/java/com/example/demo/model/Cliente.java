package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Long documentoIdentidad;
	
	@OneToMany(mappedBy="cliente",fetch = FetchType.LAZY)
	private List<Factura> facturas;
	
	public Cliente() {
	}

	public Cliente(String nombre, Long documentoIdentidad) {
		this.nombre = nombre;
		this.documentoIdentidad = documentoIdentidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getDocumentoIdentidad() {
		return documentoIdentidad;
	}

	public void setDocumentoIdentidad(Long documentoIdentidad) {
		this.documentoIdentidad = documentoIdentidad;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", documentoIdentidad=" + documentoIdentidad + "]";
	}	

}
