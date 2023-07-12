package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Factura {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String producto;
	private Long valor;
	
	@ManyToOne
	@JoinColumn
	private Cliente cliente;
	
	public Factura() {
	}

	public Factura(String producto, Long valor, Cliente cliente) {
		this.producto = producto;
		this.valor = valor;
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", producto=" + producto + ", valor=" + valor + ", cliente=" + cliente + "]";
	}
	
}
