package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundo {
	
	@GetMapping("/holamundo")
	public String holaMundo() {
		return "Hola mundo desde mi primer aplicación en Spring boot";
	}

}
