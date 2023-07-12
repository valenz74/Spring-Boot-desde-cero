package plataforma;

public class Main {

	public static void main(String[] args) {
		System.out.println("Software ejecutándose");
		
		FormaDePago pagoPayPal = new PagoPayPal();
		FormaDePago pagoTarjetaDebito = new PagoTarjetaDebito();
		
		PasarelaDePago pasarelaDePago = new PasarelaDePago(pagoTarjetaDebito);
		pasarelaDePago.pagar();
	}

}
