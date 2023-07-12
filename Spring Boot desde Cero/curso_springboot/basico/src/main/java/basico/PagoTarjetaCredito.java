package basico;

import org.springframework.stereotype.Component;

@Component
public class PagoTarjetaCredito implements FormaDePago{

	@Override
	public void ejecutarPago() {
		System.out.println("Pago tarjeta credito");
	}

}
