package com.example.demo.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.service.JwtTokenFilter;

@Configuration
public class Configuracion {
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	JwtTokenFilter jwtTokenFilter;
	
	
	public UserDetailsService inMemoryUserDetailsManager() {
		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
		inMemoryUserDetailsManager.createUser(new User("aprueba",passwordEncoder.encode("123"),new ArrayList<>()));
		return inMemoryUserDetailsManager;
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setUserDetailsService(userDetailsService);
		dao.setPasswordEncoder(passwordEncoder);
		return dao;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(auth->
		auth
		
		.requestMatchers("/home").authenticated()
		.requestMatchers("/inicio").permitAll()
		.requestMatchers("/admin").hasRole("admin")
		.requestMatchers("/login").permitAll()
		
		.requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
		)
		.headers(headers->headers.frameOptions(frameOptions->frameOptions.disable()))
		.csrf(csrf->csrf.disable())
		.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		return http.build();
	}	
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception {
		return auth.getAuthenticationManager();
	}

}
