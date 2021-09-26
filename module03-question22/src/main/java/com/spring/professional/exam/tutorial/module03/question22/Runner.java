package com.spring.professional.exam.tutorial.module03.question22;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.spring.professional.exam.tutorial.module03.question22.service.EmployeeService;

@ComponentScan
@EnableAspectJAutoProxy
public class Runner {
	
	public static void  main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
		context.registerShutdownHook();
		
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		
		employeeService.saveEmployeesUnderOneTransaction();
		employeeService.listAllEmployees();
	}

}
