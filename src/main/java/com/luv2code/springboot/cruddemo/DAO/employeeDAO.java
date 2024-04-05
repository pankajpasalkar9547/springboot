package com.luv2code.springboot.cruddemo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface employeeDAO {
	
	public List<Employee> findAll();
	@Modifying
	public Employee updateRecord(Employee theEmployee);
	public Employee findById(int theId);
}
