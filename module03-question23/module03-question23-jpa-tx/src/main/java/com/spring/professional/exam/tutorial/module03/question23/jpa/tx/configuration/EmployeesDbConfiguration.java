package com.spring.professional.exam.tutorial.module03.question23.jpa.tx.configuration;

import java.util.Properties;

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
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource(value = {"classpath:hibernate.properties"})
@EnableJpaRepositories(basePackages = {"com.spring.professional.exam.tutorial.module03.question23.jpa.tx.db.employees.dao"},
entityManagerFactoryRef = "employeeEntityManagerFactoryBean", transactionManagerRef = "employeeTransactionManager")
public class EmployeesDbConfiguration {
	
	@Autowired
	private Environment environment;
	
	protected static Properties properties = new Properties();

	
	@Bean
	@Autowired
	public LocalContainerEntityManagerFactoryBean employeeEntityManagerFactoryBean(DataSource employeesDataSource) {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(employeesDataSource);
		em.setPackagesToScan("com.spring.professional.exam.tutorial.module03.question23.jpa.tx.db.employees.ds");
		
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(hibernateProperties());
		
		return em;
		 
		
	}
	
	@Bean	
	public PlatformTransactionManager employeeTransactionManager( EntityManagerFactory employeeEntityManagerFactoryBean) {
		return new JpaTransactionManager(employeeEntityManagerFactoryBean);
	}
	
	@Bean
	public DataSource employeesDataSource() {
		return new EmbeddedDatabaseBuilder().generateUniqueName(true).setScriptEncoding("UTF-8").build();
		//return new EmbeddedDatabaseBuilder().generateUniqueName(true).setScriptEncoding("UTF-8").addScript("employee.sql").build();
	}
	
	
	private Properties hibernateProperties() {
		
		
		properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		properties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
		
		return properties;
		
	}
}
