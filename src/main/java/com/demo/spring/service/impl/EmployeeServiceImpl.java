package com.demo.spring.service.impl;

import org.springframework.stereotype.Service;

import com.demo.spring.model.Employee;
import com.demo.spring.repository.EmployeeRepository;
import com.demo.spring.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	 // optional 
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

    @Override
	public Employee saveEmployee(Employee employee) {
    	
		return employeeRepository.save(employee);
	}
}
