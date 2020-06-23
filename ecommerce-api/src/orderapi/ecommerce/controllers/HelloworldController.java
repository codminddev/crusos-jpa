package orderapi.ecommerce.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("hello")
public class HelloworldController {

	@GET
	public String hello() {
		return "Hello World";
	}
	
}
