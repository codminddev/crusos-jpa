package orderapi.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orderapi.ecommerce.entity.Order;
import orderapi.ecommerce.entity.OrderLine;

public class Cascade {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = factory.createEntityManager();
		
		Order order1 = em.find(Order.class, 1L);
		System.out.println(order1.getCustomer().getFirtname());
		System.out.println(order1.getPayment().getPayMethod().toString());
		
		for(OrderLine line: order1.getLines()) {
			System.out.println(line.getQuantity());
		}
	}
}
