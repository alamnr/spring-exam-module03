package com.spring.professional.exam.tutorial.module03.question12.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
public class DatabaseInitializer {

	@Value("classpath:/db-schema.sql")
	private Resource schemaScript;
	
	@Value("classpath:/test-data.sql")
	private Resource dataScript;
	
	@Bean
	public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
		final DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(dataSource);
		dataSourceInitializer.setDatabasePopulator(dataBasePopulator());
		return dataSourceInitializer;
	}

	private DatabasePopulator dataBasePopulator() {
		 final ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
	        databasePopulator.addScript(schemaScript);
	        databasePopulator.addScript(dataScript);
	        return databasePopulator;
	}
}