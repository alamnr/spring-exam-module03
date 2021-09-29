package com.spring.professional.exam.tutorial.module03.question26.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

	@Bean
	public DataSource dataSource() {
		
		return new EmbeddedDatabaseBuilder().generateUniqueName(true).setScriptEncoding("UTF-8").build();
	}
}
