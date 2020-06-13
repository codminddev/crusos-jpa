package orderapi.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orderapi.ecommerce.entity.Clasification;
import orderapi.ecommerce.entity.Order;
import orderapi.ecommerce.entity.OrderLine;
import orderapi.ecommerce.entity.Product;

public class ManyToMany {
	public static void main(String[] args) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = emFactory.createEntityManager();
		
		em.getTransaction().begin();
		Clasification clas1 = em.find(Clasification.class, 1L);
		Clasification clas2 = em.find(Clasification.class, 2L);
		Clasification clas3 = em.find(Clasification.class, 3L);
		
		Product product1 = em.find(Product.class, 1L);
		product1.addClasification(clas1);
		product1.addClasification(clas2);
		product1.addClasification(clas3);
		em.persist(product1);
		
		Product product2 = em.find(Product.class, 2L);
		product2.addClasification(clas1);
		product2.addClasification(clas3);
		
		em.persist(product2);
		
		em.getTransaction().commit();
	}
}
