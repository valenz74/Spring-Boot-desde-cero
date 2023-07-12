package com.example.demo.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Rol;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	UsuarioRepo usuarioRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Usuario> usuarioOptional = usuarioRepo.findByNombre(username);
		
		if(usuarioOptional.isEmpty()) {
			throw new UsernameNotFoundException("No existe, no lo dejes entrar");
		}
		
		Usuario usuario = usuarioOptional.get();
		
		User user = new User(usuario.getNombre(), usuario.getPassword(), authorities(usuario));
		
		return user;
	}
	
	private ArrayList<GrantedAuthority> authorities(Usuario usuario){
		
		ArrayList<GrantedAuthority> listadoAutoridades = new ArrayList<>();
		
		for(Rol rol:usuario.getRoles()) {
			listadoAutoridades.add(new SimpleGrantedAuthority("ROLE_"+rol.getRol()));
		}
		
		return listadoAutoridades;
		
	}
	

}
