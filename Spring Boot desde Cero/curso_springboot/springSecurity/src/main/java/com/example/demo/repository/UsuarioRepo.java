package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer>{
	Optional<Usuario> findByNombre(String nombre);
}
