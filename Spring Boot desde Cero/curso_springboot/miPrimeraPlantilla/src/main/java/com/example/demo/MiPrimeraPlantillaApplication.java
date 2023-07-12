package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiPrimeraPlantillaApplication {

	public static void main(String[] args) {
		
		new Persona(1, "Carlos", 35);
		
		SpringApplication.run(MiPrimeraPlantillaApplication.class, args);
	}

}
