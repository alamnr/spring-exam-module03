package com.spring.professional.exam.tutorial.module03.question04.jdbc.callback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.professional.exam.tutorial.module03.question04.jdbc.callback.dao.EmployeeDao;

@Service
public class EmployeeReportService {
	
	@Autowired
	EmployeeDao employeeDao ;
	
	public void printReport() {
		System.out.println("Report Printing Starting ");
		
		System.out.println("findAverageSalaryModernImplementation = "+ employeeDao.findAverageSalaryModernImplementation());
		System.out.println("findAverageSalaryRowByRow = "+employeeDao.findAverageSalaryRowByRow());
		System.out.println("findAverageSalarySqlLevel =  "+ employeeDao.findAverageSalarySqlLevel());
		System.out.println("findEmployeeIdFromEmail =  "+ employeeDao.findEmployeeIdFromEmail("John.Doe@corp.com"));
		System.out.println("findAverageSalaryCalculatedOnEntireResultSet =  "+ employeeDao.findAverageSalaryCalculatedOnEntireResultSet());
		
		System.out.println("Employees List = ");
		employeeDao.findEmployees().forEach(System.out::println);
				
		
		System.out.println("Ending Report Printing");
	}

}
