package com.luv2code.springboot.cruddemo.rest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.luv2code.springboot.cruddemo.DAO.employeeDAOHibernateImpl;
import com.luv2code.springboot.cruddemo.entity.Employee;

public class EmployeeRestControllerTest {

	@InjectMocks
	EmployeeRestController employeeRestController; 
	
	@Mock
	employeeDAOHibernateImpl employeeDAOHibernateImplTest;
	
	
	@Test
	public void EmployeeRestControllerTestFinfAll() {
		MockitoAnnotations.openMocks(this);
		employeeRestController = new EmployeeRestController(employeeDAOHibernateImplTest);
		when(employeeDAOHibernateImplTest.findAll())
		.thenReturn(Stream.of(new Employee("Pankaj", "kjsasa", "achXJKm")).collect(Collectors.toList()));
		assertEquals(1, employeeRestController.findEmpl().size());
		System.out.println(employeeDAOHibernateImplTest);
		System.out.println(employeeRestController);
		
	}

}
