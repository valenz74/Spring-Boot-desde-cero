package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Cliente;
import com.example.demo.model.Factura;

public interface FacturaRepo extends JpaRepository<Factura, Long>{
	List<Factura> findByCliente(Cliente cliente);
}
