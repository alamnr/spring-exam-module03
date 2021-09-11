package com.spring.professional.exam.tutorial.module03.question03.jdbc.template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.professional.exam.tutorial.module03.question03.jdbc.template.dao.EmployeeDao;

@Service
public class EmployeeReportService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public void printReport() {
		System.out.println("Report Printing Starting ");
		
		System.out.println("Employee count = "+ employeeDao.findEmployeesCount());
		System.out.println("First  hired employee count = "+employeeDao.findFirstHiredEmployee());
		System.out.println("Highest salary employee count =  "+ employeeDao.findEmployeeWithHighestSalary());
		System.out.println("Employees List = ");
		employeeDao.findEmployees().forEach(System.out::println);
		System.out.println("Employee emails = ");
		employeeDao.findAllEmployeeEmails().forEach(System.out::println);
		
		
		
		
		
		System.out.println("Ending Report Printing");
	}

}
