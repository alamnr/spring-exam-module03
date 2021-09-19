package com.spring.professional.exam.tutorial.module03.question11.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class DataSourceConfiguration {

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.generateUniqueName(true)
				.setScriptEncoding("UTF-8")
				.addScript("db-schema.sql")
				.build();
	}
	
	
	@Bean
	@Autowired
	public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
