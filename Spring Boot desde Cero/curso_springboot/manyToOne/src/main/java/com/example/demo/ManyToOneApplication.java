package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Cliente;
import com.example.demo.model.Factura;
import com.example.demo.repository.ClienteRepo;
import com.example.demo.repository.FacturaRepo;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class ManyToOneApplication implements CommandLineRunner{
	
	@Autowired
	ClienteRepo clienteRepo;
	
	@Autowired
	FacturaRepo facturaRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ManyToOneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cliente cliente1 = new Cliente("Carlos", 12345L);
		clienteRepo.save(cliente1);
		
		Cliente cliente2 = new Cliente("Daniela", 54321L);
		clienteRepo.save(cliente2);
		
		Factura factura1 = new Factura("Computador", 1200000L, cliente1 );
		Factura factura2 = new Factura("Celular", 1000000L, cliente1 );
		
		Factura factura3 = new Factura("Cuaderno", 12000L, cliente2 );
		Factura factura4 = new Factura("Libro", 100000L, cliente2 );
		
		List<Factura> facturas = new ArrayList<>();
		facturas.add(factura1);
		facturas.add(factura2);
		facturas.add(factura3);
		facturas.add(factura4);
		
		facturaRepo.saveAll(facturas);
		
		System.out.println(facturaRepo.findByCliente(cliente1)); 
		
		
	}

}
