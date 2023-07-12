package basico;

import org.springframework.stereotype.Component;

@Component
public class PagoPayPal implements FormaDePago{
	public PagoPayPal() {
		System.out.println("Hola soy el primer beannnnnnnn de pago pay pal");
	}
	
	
	public void ejecutarPago() {
		
		System.out.println("Ejecutar pago pay pal");
		
	}
	
	public void pagar() {
		System.out.println("Pagaste con el bean paypal");
	}
}
