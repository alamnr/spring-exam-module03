package com.spring.professional.exam.tutorial.module03.question23.jta.tx;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.spring.professional.exam.tutorial.module03.question23.jta.tx.service.WareHouseService;

@ComponentScan
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class Runner {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
		context.registerShutdownHook();
		
		WareHouseService wareHouseService = context.getBean(WareHouseService.class);
		
		wareHouseService.purgeData();
		
		try {
			wareHouseService.saveData();
		} catch (Exception e) {
			  System.out.println(e.getClass().getSimpleName() + " exception caught");
		}
		
		wareHouseService.listAllData();
		
	}

}
