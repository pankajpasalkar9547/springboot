package com.luv2code.springboot.cruddemo.DAO;

import java.util.Currency;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class employeeDAOHibernateImpl implements employeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public employeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	@Override
	@Transactional
	public List<Employee> findAll() {
		
		//get the current session hibernate
		Session currentSession = entityManager.unwrap(Session.class);
		
		//Create Query
		Query theQuery = currentSession.createQuery("from Employee",Employee.class);
		
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		//String s="new";
		//System.out.println(s);
		return employees;
	}
	
	public  Employee updateRecord(Employee theEmployee) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee getEmployee = findById(theEmployee.getId());
		getEmployee.setFirstName(theEmployee.getFirstName());
		getEmployee.setLastName(theEmployee.getLastName());
		getEmployee.setEmail(theEmployee.getEmail());
		
		currentSession.save(getEmployee);
		return getEmployee;
		
	}
	@Override
	public Employee findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		//Query theQuery = currentSession.createQuery("from emplyee where id =:theId",Employee.class);
		//theQuery.setParameter(1, theId);
		Employee theEmployee=currentSession.find(Employee.class, theId);
		//List<Employee> employees = (List<Employee>) theQuery.getSingleResult();
		return theEmployee;
	}
}
