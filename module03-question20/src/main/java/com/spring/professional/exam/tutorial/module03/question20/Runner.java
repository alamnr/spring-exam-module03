package com.spring.professional.exam.tutorial.module03.question20;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.spring.professional.exam.tutorial.module03.question20.dao.EmployeeDao;
import com.spring.professional.exam.tutorial.module03.question20.service.EmployeeService;

@ComponentScan
public class Runner {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
		context.registerShutdownHook();
		
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		EmployeeDao employeeDao = context.getBean(EmployeeDao.class);
		
		try {
			employeeService.operationsWithAutoCommit();
		} catch (Exception e) {
			System.err.println(String.format("Exception Occured : %s : %s",e.getClass().getSimpleName(),e.getMessage()));
		}
		
		employeeService.findAllemployee();
		employeeDao.deleteAllEmployees();
		System.out.println("\n\n");
		
		try {
			employeeService.operationsWithoutAutoCommit();
		} catch (Exception e) {
			System.err.println(String.format("Exception Occured : %s : %s",e.getClass().getSimpleName(),e.getMessage()));
		}
		
		employeeService.findAllemployee();
		employeeDao.deleteAllEmployees();
		
	}

}
