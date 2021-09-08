package com.spring.professional.exam.tutorial.module03.question02.embedded.builder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.professional.exam.tutorial.module03.question02.embedded.builder.dao.EmployeeDao;

@Service
public class EmployeeReportService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public void printReport() {
		System.out.println("Printing start");
		employeeDao.findEmailOfAllEmployee().forEach(System.out::println);
		System.out.println("Printing end");
	}

}
