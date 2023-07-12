package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepo;

@SpringBootApplication
public class ApiRestApplication implements CommandLineRunner{

	@Autowired
	UsuarioRepo usuarioRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario usuario1 = new Usuario("Carlos", 15);
		Usuario usuario2 = new Usuario("Catalina", 20);
		Usuario usuario3 = new Usuario("Daniel", 18);
		
		List<Usuario> usuarios = new ArrayList<>();
		
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		usuarios.add(usuario3);
		
		usuarioRepo.saveAll(usuarios);
		
		
	}

}
