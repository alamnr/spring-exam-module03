package com.spring.professional.exam.tutorial.module03.question27.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.professional.exam.tutorial.module03.question27.ds.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
	
	Employee findByFirstNameAndLastName(String firstName,String lastName);
	
	List<Employee> findTop3ByOrderBySalaryDesc();
	
	List<Employee> findByHireDateBetween(Date min, Date max);
	
	List<Employee> findByOrderByHireDateDesc();

}
