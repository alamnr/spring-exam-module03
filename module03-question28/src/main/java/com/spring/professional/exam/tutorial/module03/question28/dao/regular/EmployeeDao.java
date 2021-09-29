package com.spring.professional.exam.tutorial.module03.question28.dao.regular;

import org.springframework.data.repository.CrudRepository;

import com.spring.professional.exam.tutorial.module03.question28.ds.Employee;

public interface  EmployeeDao extends CrudRepository<Employee, Integer> {
	
	Employee findByFirstNameAndLastName(String firstName,String lastName);

}
