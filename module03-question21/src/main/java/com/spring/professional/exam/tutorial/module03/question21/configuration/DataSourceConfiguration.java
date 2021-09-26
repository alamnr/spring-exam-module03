 package com.spring.professional.exam.tutorial.module03.question21.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class DataSourceConfiguration {

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().generateUniqueName(true).setScriptEncoding("UTF-8")
				.build();
	}
}
