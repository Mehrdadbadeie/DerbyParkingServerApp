package se.yrgo.rest;

import java.util.Date;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import se.yrgo.domain.Car;
import se.yrgo.domain.Customer;
import se.yrgo.domain.ParkingTicket;


@Stateless
@Path("/parkingtickets/")
public class ParkingResource {

	@GET
	@Produces("application/JSON") // @Produces("application/XML")
	@Path("{ticketId}")
	public Response findTicketById(@PathParam("ticketId") int id) {

		/* This is just some meaningless test code to check that we are able to make requests. */
		if (id == 5) {
			Car car1 = new Car("ZER 992", "grey Lada");
			Customer customer1 = new Customer("George", "Costanza");
			
			ParkingTicket ticket = new ParkingTicket(new Date(), new Date(), 15, "Ågatan 5", car1, customer1);
			return Response.ok(ticket).build();
		}
		
		return Response.status(404).build();
	}
	
}
