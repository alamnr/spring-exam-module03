package com.spring.professional.exam.tutorial.module03.question21.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = "com.spring.professional.exam.tutorial.module03.question21.dao")
public class JpaConfiguration {

	
	
	@Bean
	@Autowired
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean em  = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);
		em.setPackagesToScan("com.spring.professional.exam.tutorial.module03.question21.ds");
		
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(hibernateProperties());
		return em;
	}
	
	@Bean(name="transactionManager") 
	public PlatformTransactionManager platformTransactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
	private Properties hibernateProperties() {
	    Properties properties = new Properties();
		/*
		 * properties.put("hibernate.dialect",
		 * environment.getRequiredProperty("hibernate.dialect"));
		 * properties.put("hibernate.show_sql",
		 * environment.getRequiredProperty("hibernate.show_sql"));
		 * properties.put("hibernate.format_sql",
		 * environment.getRequiredProperty("hibernate.format_sql"));
		 * properties.put("hibernate.hbm2ddl.auto",
		 * environment.getRequiredProperty("hibernate.automaticschema"));
		 * properties.put("hibernate.search.default.directory_provider",
		 * environment.getRequiredProperty("hibernate.search.default.directory_provider"
		 * )); properties.put("hibernate.search.default.indexBase",
		 * environment.getRequiredProperty("hibernate.search.default.indexBase"));
		 */
	    properties.put("hibernate.show_sql",true);
	    properties.put("hibernate.hbm2ddl.auto","update");
	    
	    return properties;
	}
	
	
}
