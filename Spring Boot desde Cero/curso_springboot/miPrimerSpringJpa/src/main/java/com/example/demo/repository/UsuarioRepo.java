package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Long>{
	
	public List<Usuario> findByNombreAndEdad(String nombre, Long edad);
	public List<Usuario> findByEdadGreaterThan(Long edad);
}
