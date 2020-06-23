package orderapi.ecommerce.test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orderapi.ecommerce.entity.Customer;
import orderapi.ecommerce.entity.enums.CustomerStatus;

public class Update {
	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = emFactory.createEntityManager();
		
		/*
		em.getTransaction().begin();
		
		Customer customer1 = em.find(Customer.class, 1L);
		
		customer1.setFirtname("Rebeca");
		customer1.setLastname("Iturralde");
		
		em.persist(customer1);
		
		em.getTransaction().commit();
		*/
		
		
		//em.getTransaction().begin();
		
		Customer customer1 = new Customer();
		customer1.setId(1L);
		customer1.setFirtname("Oscar");
		customer1.setLastname("Blancarte");
		customer1.setBirthday(LocalDate.now());
		customer1.setStatus(CustomerStatus.ACTIVE);
		em.merge(customer1);
		
		//em.persist(customer1);
		
		//em.getTransaction().commit();
	}
}
