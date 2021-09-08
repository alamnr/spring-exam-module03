package com.spring.professional.exam.tutorial.module03.question02.embedded.builder.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

@Configuration
public class DatasourceConfiguration {

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.generateUniqueName(true)
				.setScriptEncoding("UTF-8")
				.addScript("db-schema.sql")
				.addScript("db-test-data.sql")
				.build();
	}
}
