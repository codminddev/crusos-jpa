package orderapi.ecommerce.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orderapi.ecommerce.entity.Order;
import orderapi.ecommerce.entity.Product;

public class Collections {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = factory.createEntityManager();
		
		/*
		List<Product> products = new ArrayList<Product>();
		Order order = em.find(Order.class, 1L);
		order.getLines()
			.forEach( x -> {
				products.add(x.getProduct());
			});
		products.forEach(x-> System.out.println(x.getName()));
		*/
		
		/*
		em.createQuery("select p from Order o inner join o.lines l inner join l.product p", Product.class)
			.getResultStream()
			.forEach(x-> System.out.println(x.getName()));
		*/
		
		/*
		order
			-> join lines
			X line
				-> productos
		
		order
			-> join lines
				-> join productos
		*/	
		em.createQuery("select l.product from Order o inner join o.lines l", Product.class)
		.getResultStream()
		.forEach(x-> System.out.println(x.getName()));
		
	}
}
