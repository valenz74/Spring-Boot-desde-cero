package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class PagoTarjetaDebito implements FormaDePago{

	@Override
	public void ejecutarPago() {
		System.out.println("Pagaste con tarjeta débito");
		
	}

}
