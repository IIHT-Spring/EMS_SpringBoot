package com.demo.spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.model.Employee;
import com.demo.spring.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	// build create employee rest-api 
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		System.out.println(employee);
		return new ResponseEntity<Employee>
		(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	// get all employees rest api 
	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
		
	}
	
	// get a specific employee with the given id
	//http: //localhost:8080/api/employee/1
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long Eid){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(Eid), HttpStatus.OK);
		
	}
}
