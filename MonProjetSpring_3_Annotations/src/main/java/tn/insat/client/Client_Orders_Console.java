package tn.insat.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import tn.insat.business.IOrdersBusiness;

import java.math.BigDecimal;

@Component
public class Client_Orders_Console {
	
	@Autowired
	//@Qualifier("businessObject")
	private IOrdersBusiness business;
	
	public IOrdersBusiness getBusiness() {
		return business;
	}

	public void setBusiness(IOrdersBusiness business) {
		this.business = business;
	}

	public static void main(String[] args) {

		// Démarrer le conteneur léger (factory) de Spring
		try (ConfigurableApplicationContext context = 
				new ClassPathXmlApplicationContext("beans.xml")) {

		
			Client_Orders_Console client = 
					context.getBean(Client_Orders_Console.class);
			
			BigDecimal total = client.getBusiness().computeTotalOrderPrice("order1");
			System.out.println(" Total of the order : "+total);
			
		} // context.close();

	}
}
