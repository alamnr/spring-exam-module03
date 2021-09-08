package com.spring.professional.exam.tutorial.module03.question02.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.professional.exam.tutorial.module03.question02.boot.dao.EmployeeDao;

@Service
public class EmployeeReportService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public void printReport() {
		
		System.out.println("Starting printing Report");
		employeeDao.findEmployeeEmails().forEach(System.out::println);
		
		System.out.println("Ending printing report");
		
	}
}
