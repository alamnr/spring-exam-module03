package com.spring.professional.exam.tutorial.module03.question03.jdbc.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.professional.exam.tutorial.module03.question03.jdbc.template.service.EmployeeReportService;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner{

	@Autowired
	private EmployeeReportService employeeReportService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootConsoleApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		employeeReportService.printReport();
	}

}
