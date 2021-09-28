package com.spring.professional.exam.tutorial.module03.question23.jpa.tx;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.spring.professional.exam.tutorial.module03.question23.jpa.tx.service.WarehouseService;

@ComponentScan
@EnableTransactionManagement 
public class Runner {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
		context.registerShutdownHook();
		
		WarehouseService warehouseService = context.getBean(WarehouseService.class);
		
		 try {
	            warehouseService.saveData();
	        } catch (Exception e) {
	            System.out.println(e.getClass().getSimpleName() + " exception caught");
	        }

	        warehouseService.listAllData();
	}

}
