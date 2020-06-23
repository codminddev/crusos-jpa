package orderapi.ecommerce.test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orderapi.ecommerce.entity.Customer;

public class Delete {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		Customer customer1 = em.find(Customer.class, 1L);
		em.remove(customer1);
		em.getTransaction().commit();
	}
}
