package se.yrgo.dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import se.yrgo.domain.Employee;

@Stateless
@Default
@ProductionDao
public class EmployeeDataAccessProductionVersion implements EmployeeDataAccess {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void insert(Employee newEmployee) {
		em.persist(newEmployee);
	}

	@Override
	public List<Employee> findAll() {
		Query q = em.createQuery("select employee from Employee employee");
		List<Employee> employees = q.getResultList();
		return employees;
		
		/*
		Employee emp1 = new Employee("Bob","James","Musician",		3700);
		Employee emp2 = new Employee("Spike","Lee","Director",		2200);
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(emp1);
		employees.add(emp2);
		
		return employees;
		*/
	}

	@Override
	public List<Employee> findBySurname(String surname) {
		Query q = em.createQuery("select employee from Employee employee where employee.surname = :surname");
		q.setParameter("surname", surname);
		return q.getResultList();
	}

	@Override
	public Employee findById(int id) throws EmployeeNotFoundException {
		Query q = em.createQuery("select employee from Employee employee where employee.id = :employeeId");
		q.setParameter("employeeId", id);
		
		try {
			return (Employee)q.getSingleResult();
		} catch (NoResultException e) {
			throw new EmployeeNotFoundException();
		}
	}

	@Override
	public List<Employee> getAllEmployeesWhereIdBetween(int firstId, int secondId) {
		Query q = em.createQuery("select employee from Employee employee where employee.id >= :first and employee.id <=:second");
		q.setParameter("first", firstId);
		q.setParameter("second", secondId);
		List<Employee> employees = q.getResultList();
		return employees;
	}
	
	
}
