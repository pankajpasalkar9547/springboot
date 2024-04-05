package com.luv2code.springboot.cruddemo.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.DAO.employeeDAOHibernateImpl;
import com.luv2code.springboot.cruddemo.entity.Employee;

@RestController
@RequestMapping(path ="/api")
public class EmployeeRestController {
	
	private employeeDAOHibernateImpl employeeDAOHibernateImplobj;

	@Autowired
	public EmployeeRestController(employeeDAOHibernateImpl employeeDAOHibernateImplobj) {
		this.employeeDAOHibernateImplobj = employeeDAOHibernateImplobj;
	}

	@GetMapping(path="/employees")//,produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE} )
	public List<Employee> findEmpl()
	{
		return employeeDAOHibernateImplobj.findAll();
	}
	
	@PutMapping("/employees")
	public Employee updateRecord(@RequestBody Employee theEmployee )
	{
		return employeeDAOHibernateImplobj.updateRecord(theEmployee);
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId)
	{
		int empID = employeeId;
		return employeeDAOHibernateImplobj.findById(empID);
	}

}
