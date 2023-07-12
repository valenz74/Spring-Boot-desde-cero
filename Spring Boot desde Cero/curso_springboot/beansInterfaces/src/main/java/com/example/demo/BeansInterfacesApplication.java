package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BeansInterfacesApplication implements CommandLineRunner{
	
	@Autowired
	FormaDePago formaDePago;

	public static void main(String[] args) {
		SpringApplication.run(BeansInterfacesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		formaDePago.ejecutarPago();
	}


}
