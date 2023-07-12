package plataforma;

public class PasarelaDePago {
	
	private FormaDePago formaDePago;

	public PasarelaDePago(FormaDePago formaDePago) {
		this.formaDePago = formaDePago;
	}
	
	public void pagar() {
		System.out.println("Ejecutando el pago");
		formaDePago.ejecutarPago();
	}
}
