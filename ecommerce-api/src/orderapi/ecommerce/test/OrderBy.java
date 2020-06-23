package orderapi.ecommerce.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orderapi.ecommerce.entity.Order;
import orderapi.ecommerce.entity.OrderLine;

public class OrderBy {
	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = emFactory.createEntityManager();
		
		Order order1 = em.find(Order.class, 1L);
		
		for(OrderLine line: order1.getLines()) {
			System.out.println(line.getCtr());
		}
	}
}
