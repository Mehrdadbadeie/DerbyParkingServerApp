package se.yrgo.rest;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import se.yrgo.dataaccess.EmployeeNotFoundException;
import se.yrgo.domain.Employee;
import se.yrgo.service.EmployeeManagementServiceLocal;

@Stateless
@Path("/employees/")
public class EmployeeResource {

	@Inject
	private EmployeeManagementServiceLocal service;

	@GET
	@Produces("application/JSON")
	public Response getAllEmployeesWhereIdBetween(@DefaultValue("0") @QueryParam("firstId") Integer firstId,
			@QueryParam("secondId") Integer secondId) {
		/*
		 * if (firstId == null && secondId == null) { return service.getAllEmployees();
		 * } if (firstId != null && secondId != null) { return
		 * service.getAllEmployeesWhereIdBetween(firstId, secondId); }
		 */
		if (firstId == 0 && secondId == null) {
			return Response.ok(service.getAllEmployees()).build();
		}
		
		if (firstId != null && secondId != null) {
			return Response.ok(service.getAllEmployeesWhereIdBetween(firstId, secondId)).build();
		}

		return Response.status(400).build();
	}

	/*
	 * @GET
	 * 
	 * @Produces("application/JSON") public List<Employee> getAllEmployees() {
	 * return service.getAllEmployees(); }
	 */
	@GET
	@Produces("application/JSON") // @Produces("application/XML")
	@Path("{employeeNo}")
	public Response findEmployeeById(@PathParam("employeeNo") int id) {

		try {
			// return service.getById(id);
			Employee result = service.getById(id);
			return Response.ok(result).build();
		} catch (EmployeeNotFoundException e) {
			// return null;
			return Response.status(404).build();
		}
	}

	@POST
	@Produces("application/JSON")
	@Consumes("application/JSON")
	public Employee createEmployee(Employee employee) {
		service.registerEmployee(employee);
		return employee;
	}

}
