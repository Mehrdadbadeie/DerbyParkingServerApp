package se.yrgo.service;

import se.yrgo.dataaccess.EmployeeNotFoundException;
import se.yrgo.domain.Employee;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EmployeeManagementServiceLocal {
	
	public void registerEmployee(Employee employee);
	public List<Employee> getAllEmployees ();
	public List<Employee> searchBysurname(String surname);
	public Employee getById(int id) throws EmployeeNotFoundException;
	public List<Employee> getAllEmployeesWhereIdBetween(int firstId, int secondId);
}
