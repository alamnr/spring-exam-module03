package com.spring.professional.exam.tutorial.module03.question23.jpa.tx.configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource(value = "classpath:hibernate.properties")
@EnableJpaRepositories(basePackages = "com.spring.professional.exam.tutorial.module03.question23.jpa.tx.db.products.dao",
		entityManagerFactoryRef = "productEntityManagerFactoryBean",transactionManagerRef = "productTransactionManager")
public class ProductDbConfiguration {
	
	/*
	@Autowired
	private Environment environment;*/
	
	
	@Bean
	@Autowired
	public LocalContainerEntityManagerFactoryBean productEntityManagerFactoryBean(DataSource productsDataSource) {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		
		em.setDataSource(productsDataSource);
		em.setPackagesToScan("com.spring.professional.exam.tutorial.module03.question23.jpa.tx.db.products.ds");
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		EmployeesDbConfiguration.properties.forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));
		em.setJpaProperties(EmployeesDbConfiguration.properties);
		return em;
	}
	
	@Bean
	public PlatformTransactionManager productTransactionManager(EntityManagerFactory productEntityManagerFactoryBean) {
		return new JpaTransactionManager(productEntityManagerFactoryBean);
	}
	

	@Bean 
	public DataSource productsDataSource() {
		return new EmbeddedDatabaseBuilder().generateUniqueName(true).setScriptEncoding("UTF-8").build();
		//return new EmbeddedDatabaseBuilder().generateUniqueName(true).setScriptEncoding("UTF-8").addScript("product.sql").build();
	}
	
	

}
