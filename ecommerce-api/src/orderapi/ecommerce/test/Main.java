package orderapi.ecommerce.test;

import java.time.LocalDate;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orderapi.ecommerce.entity.Customer;
import orderapi.ecommerce.entity.enums.CustomerStatus;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		Customer customer1 = new Customer();
		//customer1.setId(1);
		customer1.setFirtname("Oscar");
		customer1.setLastname("Blancarte");
		customer1.setBirthday(LocalDate.now());
		customer1.setStatus(CustomerStatus.ACTIVE);
		em.persist(customer1);
		
		Customer customer2 = new Customer();
		//customer1.setId(1);
		customer2.setFirtname("Juan");
		customer2.setLastname("Perez");
		customer2.setBirthday(LocalDate.now());
		customer2.setStatus(CustomerStatus.INACTIVE);
		em.persist(customer2);

		em.getTransaction().commit();
		
		//Customer findCustomer = em.find(Customer.class, 1L);
		//System.out.print("findCustomer => " + findCustomer.getStatus().toString());
		
		
	}
}
