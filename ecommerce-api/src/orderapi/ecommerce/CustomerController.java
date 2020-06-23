package orderapi.ecommerce;

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

@Path("customers")
@Stateless
public class CustomerController {
	
	@PersistenceContext(unitName = "ecommerce-jpa")
	private EntityManager manager;

	@GET
	public Response findAll() {
		List<Customer> customers = this.manager.createQuery("select e from Customer e", Customer.class).getResultList();
		return Response.ok(customers).build();
	}

	@GET
	@Path("{customerId}")
	public Response findById(@PathParam("customerId") Long id) {
		Customer customer = (Customer) this.manager.find(Customer.class, id);
		return Response.ok(customer).build();
	}

	@POST
	public Response create(Customer customer) {
		this.manager.persist(customer);
		return Response.ok(customer).build();
	}

	@PUT
	public Response update(Customer customer) {
		Customer mergeCustomer = (Customer) this.manager.merge(customer);
		return Response.ok(mergeCustomer).build();
	}

	@DELETE
	@Path("{customerId}")
	public Response delete(@PathParam("customerId") Long customerId) {
		this.manager.createQuery("delete from Customer c where c.id = :customerId")
				.setParameter("customerId", customerId).executeUpdate();
		return Response.ok().build();
	}
	
}
