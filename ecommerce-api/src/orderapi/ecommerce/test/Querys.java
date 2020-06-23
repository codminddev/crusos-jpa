package orderapi.ecommerce.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import orderapi.ecommerce.entity.Customer;

public class Querys {
	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = emFactory.createEntityManager();
		
		// JPQL = Java Persistence Query Language
		/*
		Query query = em.createQuery("SELECT e FROM Customer e WHERE e.firtname = :firtname"); //SELECT * FROM Customers
		query.setParameter("firtname", "Juan");
		List<Customer> customers = query.getResultList();
		*/
		
		TypedQuery<Customer> query = em.createQuery("SELECT e FROM Customer e WHERE e.firtname = :firtname", Customer.class); //SELECT * FROM Customers
		query.setParameter("firtname", "Juan");
		List<Customer> customers = query.getResultList();
		
		
		for(Customer current : customers) {
			System.out.println(current.getFirtname());
		}
		
	}
}
