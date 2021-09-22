package com.spring.professional.exam.tutorial.module03.question15.aspectj;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.spring.professional.exam.tutorial.module03.question15.aspectj.service.EmployeeService;

@ComponentScan
public class Runner {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
		context.registerShutdownHook();
		
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		
		//employeeService.transaction1and2();
		
		employeeService.transaction1and2PrecedingWithTransaction();
	}

}
