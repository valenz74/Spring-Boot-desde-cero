package basico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {
	
	@Autowired
	FormaDePago formaDePago;
	
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		context.getBean(Main.class).run();
	}
	
	public void run() {
		formaDePago.ejecutarPago();
	}

}
