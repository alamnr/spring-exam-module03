package com.spring.professional.exam.tutorial.module03.question18;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.spring.professional.exam.tutorial.module03.question18.exception.CustomException;
import com.spring.professional.exam.tutorial.module03.question18.service.EmployeeService;

@ComponentScan
public class Runner {
	
	public static void main(String[] args) throws CustomException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
		context.registerShutdownHook();
		
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		
		 try {
	            employeeService.methodWithUncheckedExceptionCausingRollBack();
	        } catch (Exception e) {
	            System.out.println(String.format("Exception thrown: %s: %s\n\n", e.getClass().getSimpleName(), e.getMessage()));
	        }

	        try {
	            employeeService.methodWithCheckedExceptionNotCausingRollBack();
	        } catch (Exception e) {
	            System.out.println(String.format("Exception thrown: %s: %s\n\n", e.getClass().getSimpleName(), e.getMessage()));
	        }

	        try {
	            employeeService.methodWithUncheckedExceptionThatNotcausingRollback();
	        } catch (Exception e) {
	            System.out.println(String.format("Exception thrown: %s: %s\n\n", e.getClass().getSimpleName(), e.getMessage()));
	        }

	        try {
	            employeeService.methodWithCheckedExceptionThatCauseRollback();
	        } catch (Exception e) {
	            System.out.println(String.format("Exception thrown: %s: %s\n\n", e.getClass().getSimpleName(), e.getMessage()));
	        }
	}

}
