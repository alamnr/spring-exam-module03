package com.spring.professional.exam.tutorial.module03.question02.standalone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.professional.exam.tutorial.module03.question02.standalone.dao.EmployeeDao;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public void printReport() {
		System.out.println("Employee Report Start");
		
		employeeDao.findEmployeeEmails().forEach(System.out::println);
		
		System.out.println("Employee Report Stop");
	}
	
}
