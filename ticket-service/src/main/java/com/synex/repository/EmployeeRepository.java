package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}
