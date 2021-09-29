package com.spring.professional.exam.tutorial.module03.question24.jpa.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.professional.exam.tutorial.module03.question24.jpa.spring.boot.service.EmployeeService;

@SpringBootApplication
public class Runner implements CommandLineRunner {
	
	@Autowired
	private EmployeeService employeeService;
	
	public static void main(String[] args) {
		SpringApplication.run(Runner.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			employeeService.saveAllEmployees();
		} catch (Exception e) {
			System.out.println("Exception thrown from .... " + e.getClass().getName());
		}
		
		employeeService.listAllemployees();
	}
}
