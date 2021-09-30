package com.spring.professional.exam.tutorial.module03.question29.service;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.professional.exam.tutorial.module03.question29.ds.Employee;
import com.spring.professional.exam.tutorial.module03.question29.dao.EmployeeDao;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Transactional
	public void findEmployeeByfirstNameAndLastName() {
		
			System.out.println(employeeDao.findByFirstNameAndLastName("John", "Doe").toString());
			
			 employeeDao.save(new Employee(6, "John", "Doe", "John.Doe@corp.com", "555-55-55", Date.valueOf("2019-06-05"), 70000));
			    
			
			System.out.println("Thrown unchecked exception to check @Transactional annotation roll back");
			throw new IllegalArgumentException();
		
	}
}
