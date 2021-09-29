package com.spring.professional.exam.tutorial.module03.question28.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.professional.exam.tutorial.module03.question28.dao.custom.CustomEmployeeDao;
import com.spring.professional.exam.tutorial.module03.question28.dao.regular.EmployeeDao;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private CustomEmployeeDao customEmployeeDao;
	
	public void queryEmployee() {
		System.out.println("Searching for John Doe employee with Simple Jpa implementation.");
		
		System.out.println(employeeDao.findByFirstNameAndLastName("John", "Doe"));
		
		System.out.println("Searching for John Doe employee with custom dao implementation.");
		
		System.out.println(customEmployeeDao.findByFirstNameAndLastName("John", "Doe"));
	}
}
