package orderapi.ecommerce.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orderapi.ecommerce.entity.Order;

public class LazyEaderLoading {
	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = emFactory.createEntityManager();
		
		Order order = em.find(Order.class, 1L);
		System.out.println(order.getCustomer().getFirtname());
		System.out.println(order.getPayment().getPayMethod());
		
		
		// N Query + 1
		order.getLines().get(0).getProduct();
	}
}
