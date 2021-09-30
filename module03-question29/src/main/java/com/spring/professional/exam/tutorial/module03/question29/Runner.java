package com.spring.professional.exam.tutorial.module03.question29;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.spring.professional.exam.tutorial.module03.question29.service.EmployeeService;

@ComponentScan
public class Runner {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
		context.registerShutdownHook();
		
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		
		
		try {
			employeeService.findEmployeeByfirstNameAndLastName();
		} catch (Exception e) {
			System.out.println("Exception thrown from "+e.getClass().getName() +" :: " +e.getMessage());
		}
	}

}
