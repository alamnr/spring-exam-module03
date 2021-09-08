package com.spring.professional.exam.tutorial.module03.question02.application.server.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@Configuration
public class DatasourceConfiguration {

	@Bean
	public DataSource dataSource() {
		return new JndiDataSourceLookup().getDataSource("jdbc/Database");
	}
}
