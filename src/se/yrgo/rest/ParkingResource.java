package se.yrgo.rest;

import java.util.Date;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import se.yrgo.domain.Car;
import se.yrgo.domain.Customer;
import se.yrgo.domain.Employee;
import se.yrgo.domain.ParkingTicket;


@Stateless
@Path("/parkingtickets/")
public class ParkingResource {

	@GET
	@Produces("application/JSON") // @Produces("application/XML")
	@Path("{ticketId}")
	/**
	 *  You can access this REST interface from: http://localhost:8080/EmployeeManagement/webservice/parkingtickets/5
	 */
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

	@DELETE
	@Produces("application/JSON") // @Produces("application/XML")
	@Path("{ticketId}")
	/**
	 *  You can access this REST interface from: http://localhost:8080/EmployeeManagement/webservice/parkingtickets/5
	 */
	public Response deleteTicketById(@PathParam("ticketId") int id) {

		/* This is just some meaningless test code to check that we are able to make requests. */
		if (id == 5) {
			return Response.ok(null).build();
		}

		return Response.status(404).build();
	}
	
	
	@POST
	@Produces("application/JSON")
	@Consumes("application/JSON")
	public Response createEmployee(Employee employee) {
		return Response.ok(employee).build();
	}

}
