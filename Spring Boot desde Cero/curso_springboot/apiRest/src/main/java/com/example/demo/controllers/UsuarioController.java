package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepo;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
		
		@Autowired
		UsuarioRepo usuarioRepo;
	
		@GetMapping("/")
		public ResponseEntity<List<Usuario>> obtenerUsuarios(){
			return new ResponseEntity<List<Usuario>> (usuarioRepo.findAll(), HttpStatus.OK);
		}
		
		@GetMapping("/{id}")
		public ResponseEntity obtenerUsuario(@PathVariable String id){
			Optional<Usuario> usuarioOptional = usuarioRepo.findById(Integer.parseInt(id));
			
			if(usuarioOptional.isEmpty()) {
				return new ResponseEntity<>("Usuario no encontrado",HttpStatus.NOT_FOUND);
			}
			return ResponseEntity.ok(HttpStatus.OK);	
		}
		
		@PostMapping("/")
		public ResponseEntity<Usuario> agregarUsuario(@RequestBody Usuario usuario){
			Usuario usuario_ = usuarioRepo.save(usuario);
			return new ResponseEntity<Usuario>(usuario_ ,HttpStatus.CREATED);
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<Usuario> actualizarUsuario(@PathVariable String id, 
				@RequestBody Usuario usuario){
			
			Optional<Usuario> usuarioOptional = usuarioRepo.findById(Integer.parseInt(id));
			
			if(usuarioOptional.isPresent()) {
				Usuario usuario_ = usuarioOptional.get();
				usuario_.setNombre(usuario.getNombre());
				usuario_.setEdad(usuario.getEdad());
				
				return new ResponseEntity<>(usuarioRepo.save(usuario_), HttpStatus.OK);
			}
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity borrarUsuario(@PathVariable String id) {
			Optional<Usuario> usuarioOptional = usuarioRepo.findById(Integer.parseInt(id));
			
			if(usuarioOptional.isPresent()) {
				usuarioRepo.deleteById(Integer.parseInt(id));
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity(new Usuario(), HttpStatus.NOT_FOUND);
			
		}
		
}
