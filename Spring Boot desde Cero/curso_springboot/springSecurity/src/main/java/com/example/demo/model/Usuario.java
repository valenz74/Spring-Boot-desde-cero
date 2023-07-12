package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String password;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinColumn
	private Set<Rol> roles;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	
	public Usuario(String nombre, String password, HashSet<Rol> roles) {
		this.nombre = nombre;
		this.password = password;
		this.roles = roles;
	}
	
	

}
