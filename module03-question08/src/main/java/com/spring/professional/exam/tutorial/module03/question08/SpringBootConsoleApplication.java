package com.spring.professional.exam.tutorial.module03.question08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.professional.exam.tutorial.module03.question08.service.EmployeesService;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {
	
	@Autowired
	private EmployeesService employeesService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConsoleApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		try {
			employeesService.saveEmployeesWithoutTransaction();
		} catch (Exception e) {
			System.out.println("Exception during saving employees "+ e.getMessage());
		}
		
		employeesService.printEmployee();
		employeesService.deleteAllEmployee();
		
		try {
			employeesService.saveEmployeesInTransaction();
		} catch(Exception e) {
			System.out.println("Exception during saving employees "+ e.getMessage());
		}
		
		employeesService.printEmployee();
		employeesService.deleteAllEmployee();
		
	}
	

}
