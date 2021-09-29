package com.spring.professional.exam.tutorial.module03.question26.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource(value = "classpath:hibernate.properties")
@EnableJpaRepositories(basePackages = "com.spring.professional.exam.tutorial.module03.question26.dao",
			transactionManagerRef = "jpaTransactionManager",entityManagerFactoryRef = "entityManagerFactoryBean")
public class JpaConfiguration {
	
	@Autowired
	private Environment environment;
	
	@Bean
	@Autowired
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource) {
		
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		
		em.setDataSource(dataSource);
		em.setPackagesToScan("com.spring.professional.exam.tutorial.module03.question26.ds");
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		em.setJpaProperties(getProperties());
		return em;
	}
	
	@Bean
	public PlatformTransactionManager jpaTransactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
	private Properties getProperties() {
		Properties properties = new Properties();
		
		properties.put("hibernate.show_sql", environment.getProperty("show_sql"));
		properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hbm2ddl.auto"));
		
		return properties;
	}

}
