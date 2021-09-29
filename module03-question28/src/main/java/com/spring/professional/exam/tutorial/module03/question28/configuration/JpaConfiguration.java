package com.spring.professional.exam.tutorial.module03.question28.configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.spring.professional.exam.tutorial.module03.question28.dao.base.CustomBaseJpaRepository;
import com.spring.professional.exam.tutorial.module03.question28.ds.Employee;

@Configuration
@EnableJpaRepositories(
		repositoryBaseClass = CustomBaseJpaRepository.class,
		basePackages = "com.spring.professional.exam.tutorial.module03.question28.dao",
		entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager"
		)
public class JpaConfiguration {
	
	@Bean
	@Autowired
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);
		em.setPackagesToScan("com.spring.professional.exam.tutorial.module03.question28.ds");
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		
		return em;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

}
