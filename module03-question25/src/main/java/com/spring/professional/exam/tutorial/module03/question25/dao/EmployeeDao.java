package com.spring.professional.exam.tutorial.module03.question25.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.professional.exam.tutorial.module03.question25.ds.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
	
	Employee findByEmail(String email);
	
	List<Employee> findByLastName(String lastName);
	
	List<Employee> findBySalaryBetween(float min,float max); 

}
