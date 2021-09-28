package com.spring.professional.exam.tutorial.module03.question23.jta.tx.configuration;

import javax.transaction.SystemException;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;

@Configuration
public class JtaConfiguration {
	
	@Bean
	public UserTransaction atomikosUserTransaction() throws SystemException {
		UserTransactionImp userTransactionImp = new UserTransactionImp();
		userTransactionImp.setTransactionTimeout(1000);
		return userTransactionImp;
	}
	
	@Bean(initMethod = "init" , destroyMethod = "close")
	public UserTransactionManager atomikosUserTransactionManager() {
		UserTransactionManager userTransactionManager = new UserTransactionManager();
		userTransactionManager.setForceShutdown(false);
		return userTransactionManager;
	}
	
	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(UserTransaction atomikosUserTransaction,TransactionManager atomikosUserTransactionManager) {
			return new JtaTransactionManager(atomikosUserTransaction,atomikosUserTransactionManager);
	}	

}
