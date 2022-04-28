package com.demo.spring.service;

import java.util.List;

import com.demo.spring.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();

}
