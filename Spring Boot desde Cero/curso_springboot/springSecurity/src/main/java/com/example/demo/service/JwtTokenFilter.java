package com.example.demo.service;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.JWTVerifier;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class JwtTokenFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//Bearer e
		String authHeader = request.getHeader("Authorization");
		
		if(authHeader!=null) {
			if(authHeader.startsWith("Bearer ")) {
				String jwtToken = authHeader.substring(7);
				
				JWTVerifier verifier = JWT.require(Algorithm.HMAC256("hola")).build();
				
				verifier.verify(jwtToken);
				
				if(Instant.now().isBefore(JWT.decode(jwtToken).getExpiresAtAsInstant())) {
					String username = JWT.decode(jwtToken).getClaim("username").asString();
					List<String> authorities = JWT.decode(jwtToken).getClaim("roles").asList(String.class);
					
					ArrayList<GrantedAuthority> listadoAutoridades = new ArrayList<>();
					
					for(String authority:authorities) {
						listadoAutoridades.add(new SimpleGrantedAuthority(authority));
					}
					
					UsernamePasswordAuthenticationToken token 
					= new UsernamePasswordAuthenticationToken(username, null,listadoAutoridades);
					
					SecurityContextHolder.getContext().setAuthentication(token);
				}else {
					return;
				}
			}
		}
		
		filterChain.doFilter(request, response);
	}

}
