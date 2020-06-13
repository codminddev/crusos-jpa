package orderapi.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orderapi.ecommerce.entity.Customer;
import orderapi.ecommerce.entity.Order;
import orderapi.ecommerce.entity.OrderLine;
import orderapi.ecommerce.entity.Payment;
import orderapi.ecommerce.entity.enums.PayMethod;

public class OneToOne {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ecommerce-jpa");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		Customer customer1 = em.find(Customer.class, 1L);

		Order order = new Order();
		order.setCustomer(customer1);
		em.persist(order);

		for (int c = 0; c < 10; c++) {
			OrderLine line = new OrderLine();
			line.setProduct("Product " + (c + 1));
			line.setQuantity(c + 1d);
			line.setUnitPrice((c + 1) * 10d);
			order.addLines(line);

			em.persist(line);
		}
		Payment payment = new Payment();
		payment.setAmount(order.getTotal());
		payment.setPayMethod(PayMethod.CREDIT);
		order.setPayment(payment);
		
		em.persist(payment);
		
		em.persist(order);

		em.getTransaction().commit();
		
		
		em.detach(order);
		em.detach(payment);
		
		Order order1 = em.find(Order.class, 1L);
		System.out.println(order1.getPayment().getPayMethod());
		
	}
}
