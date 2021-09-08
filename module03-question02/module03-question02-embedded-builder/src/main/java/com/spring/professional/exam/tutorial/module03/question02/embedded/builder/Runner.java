package com.spring.professional.exam.tutorial.module03.question02.embedded.builder;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.spring.professional.exam.tutorial.module03.question02.embedded.builder.service.EmployeeReportService;

@ComponentScan
public class Runner {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
		context.registerShutdownHook();
		
		EmployeeReportService employeeReportService = context.getBean(EmployeeReportService.class);
		employeeReportService.printReport();
	}
}
