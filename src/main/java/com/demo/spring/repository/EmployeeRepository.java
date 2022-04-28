package com.demo.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.spring.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	

}
