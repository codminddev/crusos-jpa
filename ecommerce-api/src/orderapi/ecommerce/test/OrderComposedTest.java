package orderapi.ecommerce.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orderapi.ecommerce.entity.Customer;
import orderapi.ecommerce.entity.Order;
import orderapi.ecommerce.entity.OrderComposed;
import orderapi.ecommerce.entity.OrderPK;

public class OrderComposedTest {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		Customer customer = em.find(Customer.class, 1L);
		
		
		OrderComposed order = new OrderComposed();
		order.setSerie("A");
		order.setFolio(1L);
		order.setCustomer(customer);
		
		em.persist(order);
		
		
		em.getTransaction().commit();
		
		
		OrderPK pk = new OrderPK("A", 1L);
		OrderComposed savedOrder = em.find(OrderComposed.class, pk);
		System.out.println(savedOrder.getSerie());
	}
}
