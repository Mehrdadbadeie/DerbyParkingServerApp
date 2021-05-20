package se.yrgo.service;

import se.yrgo.dataaccess.EmployeeNotFoundException;
import se.yrgo.domain.Employee;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface EmployeeManagementService {
	
	public void registerEmployee(Employee employee);
	public List<Employee>getAllEmployees ();
	public List<Employee>searchBysurname(String surname);
	public Employee getById(int id) throws EmployeeNotFoundException;
}
