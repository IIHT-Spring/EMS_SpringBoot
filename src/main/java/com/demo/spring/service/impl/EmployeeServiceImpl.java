package com.demo.spring.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.spring.exception.ResourceNotFoundException;
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

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if (employee.isPresent()) {
//			return employee.get();
//		} else {
//			throw new ResourceNotFoundException("Employee", "id", id);
//		}
		return employeeRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("employee", "id", id));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		// we need to check if the employee with the id exists or it doesnt
		
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "id", id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		// save existing eomployee into the data base
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		// check weather the id which is being passed exists on db or it doesnt
		employeeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "id", id));
		employeeRepository.deleteById(id);
	}
































}
