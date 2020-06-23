package orderapi.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orderapi.ecommerce.entity.Customer;

public class Find {
	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = emFactory.createEntityManager();
		
		Customer customer = em.find(Customer.class, 1L);
		System.out.println(customer.getFirtname());
		
		//Object customer2 = em.find(Object.class, 1L);
		
	}
}
