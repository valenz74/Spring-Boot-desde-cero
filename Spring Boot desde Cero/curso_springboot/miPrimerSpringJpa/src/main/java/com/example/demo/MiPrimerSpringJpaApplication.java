package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepo;

@SpringBootApplication
public class MiPrimerSpringJpaApplication implements CommandLineRunner{
	
	@Autowired
	UsuarioRepo usuarioRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(MiPrimerSpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario usuario1 = new Usuario("Carlos", 35L);
		Usuario usuario2 = new Usuario("Carolina", 10L);
		Usuario usuario3 = new Usuario("Alejandra", 12L);
		Usuario usuario4 = new Usuario("Carolina", 10L);
		
		List<Usuario> usuarios = new ArrayList<>();
		
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		usuarios.add(usuario3);
		usuarios.add(usuario4);
		
		usuarioRepo.saveAll(usuarios);
		
		List<Usuario> usuariosEncontrados = usuarioRepo.findByEdadGreaterThan(10L);
		
		System.out.println(usuariosEncontrados);
	}

}
