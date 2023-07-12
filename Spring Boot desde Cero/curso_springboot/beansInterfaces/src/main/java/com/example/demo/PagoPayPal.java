package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PagoPayPal implements FormaDePago{

	@Override
	public void ejecutarPago() {
		System.out.println("Pagaste con PayPal");
	}	

}
