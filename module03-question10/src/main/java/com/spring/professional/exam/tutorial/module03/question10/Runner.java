package com.spring.professional.exam.tutorial.module03.question10;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring.professional.exam.tutorial.module03.question10.config.DatasourceConfiguration;
import com.spring.professional.exam.tutorial.module03.question10.service.EmployeeService;

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
        employeeService.printEmployee();
        employeeService.deleteAllEmployee();

        try {
            employeeService.saveEmployeesInTransaction();
        } catch (Exception e) {
            System.out.println("Exception during saving employees: " + e.getMessage());
        }
        employeeService.printEmployee();
        employeeService.deleteAllEmployee();
	}
}
