package com.example.demo;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.model.Rol;
import com.example.demo.model.Usuario;
import com.example.demo.repository.RolRepo;
import com.example.demo.repository.UsuarioRepo;

@SpringBootApplication
public class SpringSecurityApplication implements CommandLineRunner{
	
	@Autowired
	UsuarioRepo usuarioRepo;
	
	@Autowired
	RolRepo rolRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Rol rolAdmin = new Rol("admin");
		rolRepo.save(rolAdmin);
		
		Rol rolUser = new Rol("user");
		rolRepo.save(rolUser);
		
		HashSet<Rol> rolesUsuario1 = new HashSet<>();
		rolesUsuario1.add(rolAdmin);
		
		
		HashSet<Rol> rolesUsuario2 = new HashSet<>();
		rolesUsuario2.add(rolUser);
		
		
		Usuario usuario1 = new Usuario("aprueba-extreme", 
				passwordEncoder.encode("12"),rolesUsuario1);
		usuarioRepo.save(usuario1);
		
		Usuario usuario2 = new Usuario("catalina", 
				passwordEncoder.encode("123"), rolesUsuario2);
		usuarioRepo.save(usuario2);
		
		
		System.out.println(usuario1);
	}

}
