package com.spring.professional.exam.tutorial.module03.question17;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.spring.professional.exam.tutorial.module03.question17.service.EmployeeService;

@ComponentScan
public class Runner {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
		context.registerShutdownHook();
		
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		
		employeeService.declarativeTransaction();
		
		
		try {
			employeeService.manualTransaction();
		} catch (Exception e) {
			System.out.println("Exception while executing manual transaction: "+ e.getMessage());
		}
	}

}
