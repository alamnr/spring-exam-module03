package com.spring.professional.exam.tutorial.module03.question13;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.spring.professional.exam.tutorial.module03.question13.service.EmployeeService;

@ComponentScan
public class Runner {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
		context.registerShutdownHook();
		
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		
		try {
            employeeService.saveEmployeeWithoutTransaction();
        } catch (Exception e) {
            System.out.println("Exception during saving employees: " + e.getMessage());
        }
        employeeService.printEmployees();
        employeeService.deleteAllEmployee();

        try {
            employeeService.saveEmployeeInTransaction();
        } catch (Exception e) {
            System.out.println("Exception during saving employees: " + e.getMessage());
        }
        employeeService.printEmployees();
        employeeService.deleteAllEmployee();
		
	}

}
