package orderapi.ecommerce.controllers;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import orderapi.ecommerce.entity.Customer;
import orderapi.ecommerce.entity.Order;

@Path("orders")
@Stateless
public class OrderController {

	@PersistenceContext(unitName = "ecommerce-jpa")
	private EntityManager manager;

	@GET
  public Response findAll() {
    List<Order> orders = this.manager
    		.createQuery("select e from Order e", Order.class)
    		.getResultList();
    orders.forEach(x -> x.getLines().forEach(l -> {
    	l.setOrder(null);
    }));
    return Response.ok(orders).build();
  }

	@GET
	@Path("{orderId}")
	public Response findById(@PathParam("orderId") Long orderId) {
		Order order = (Order) this.manager.find(Order.class, orderId);
		order.getLines().forEach(l -> l.setOrder(null));
		return Response.ok(order).build();
	}

	@POST
	public Response create(Order order) {
		Customer customer = (Customer) this.manager.find(Customer.class, order.getCustomer().getId());
		
		order.setCustomer(customer);
		order.getLines().forEach(l -> l.setOrder(order));
		
		this.manager.persist(order);
		this.manager.flush();
		
		order.getLines().forEach(l -> l.setOrder(null));
		
		return Response.ok(order).build();
	}

	@PUT
	public Response update(Order order) {
		System.out.println("ID => " + order.getId());
		
		order.getLines().forEach(l -> l.setOrder(order));
		
		Order mergeOrder = (Order) this.manager.merge(order);
		this.manager.flush();
		
		mergeOrder.getLines().forEach(l -> l.setOrder(null));
		
		return Response.ok(mergeOrder).build();
	}

	@DELETE
	@Path("{orderId}")
	public Response delete(@PathParam("orderId") Long orderId) {
		Order order = (Order) this.manager.find(Order.class, orderId);
		this.manager.remove(order);
		return Response.ok().build();
	}
}
