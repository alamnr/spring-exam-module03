package com.spring.professional.exam.tutorial.module03.question15.aspectj.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.spring.professional.exam.tutorial.module03.question15.aspectj.aspect.DatasourceProxyFactory;

@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
public class DataSourceconfiguration {

	@Bean
	public DataSource dataSource() {
		return DatasourceProxyFactory.createDataSourceProxy(new EmbeddedDatabaseBuilder().generateUniqueName(true)
				.setScriptEncoding("UTF-8").build());
	}
	
	@Bean
	@Autowired
	public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
