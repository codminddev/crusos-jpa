package orderapi.ecommerce.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Tuple;

import orderapi.ecommerce.entity.Order;

public class TypedQuery {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = factory.createEntityManager();
		
		/*
		Query query = em.createQuery("select o from Order o where o.id = :id");
		query.setParameter("id", 1L);
		List<Order> orders = query.getResultList();
		orders.stream().forEach(x -> System.out.println(x.getId()));
		*/
		
		/*
		Query query = em.createQuery("select o from Order o where o.id = :id");
		query.setParameter("id", 100L);
		Order order = (Order) query.getSingleResult();
		System.out.println(order.getId());
		*/
		
		/*
		em.createQuery("select o from Order o where o.id = :id and size(o.lines) > :lines", Order.class)
			.setParameter("id", 1L)
			.setParameter("lines", 0)
			.setHint("hont1", 1)
			.setFirstResult(10)
			.setMaxResults(10)
			.getResultList()
			.stream()
			.forEach(x-> System.out.println(x.getId()));
		*/
		
		/*
		Order order = em.createQuery("select o from Order o", Order.class)
			.getSingleResult();
		*/
		
		/*
		List<Object[]> results = em.createQuery("select o.id, o.total from Order o")
			.getResultList();
		
		for(Object[] row: results) {
			System.out.println(row[0] + ", " + row[1]);
		}
		*/
		
		List<Tuple> results = em.createQuery("select o.id as id, o.total as total from Order o", Tuple.class)
			.getResultList();
			
		for(Tuple row: results) {
			System.out.println(row.get("id") + ", " + row.get("total"));
		}
		
		
		Object result = em.createNativeQuery("select now()")
				.getSingleResult();
		System.out.println(result.toString());
	}
}
