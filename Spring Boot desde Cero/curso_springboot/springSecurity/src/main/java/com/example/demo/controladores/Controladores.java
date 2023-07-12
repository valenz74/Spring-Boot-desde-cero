package com.example.demo.controladores;

import java.time.Instant;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Verification;

@RestController
public class Controladores {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@GetMapping("/inicio")
	public String inicio() {
		return "Hola soy inicio";
	}
	
	@GetMapping("/home")
	public String home() {
		return "Hola soy el home";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "Hola admin";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password) {
		UsernamePasswordAuthenticationToken token = 
				new UsernamePasswordAuthenticationToken(username, password);
		authenticationManager.authenticate(token);
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		
		ArrayList<String> listadoRoles = new ArrayList<>();
		
		for(GrantedAuthority authority:userDetails.getAuthorities()) {
			 listadoRoles.add(authority.getAuthority());
		}
		
		String jwtToken = JWT
				.create()
				.withClaim("username", username)
				.withClaim("roles", listadoRoles)
				.withExpiresAt(Instant.now().plusSeconds(86400))
				.sign(Algorithm.HMAC256("hola"));
		
		
		return jwtToken;
	}
	
	
	
	
	
	
	

}
