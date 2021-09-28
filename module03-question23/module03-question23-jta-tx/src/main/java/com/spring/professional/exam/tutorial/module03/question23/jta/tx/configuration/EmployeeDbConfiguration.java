package com.spring.professional.exam.tutorial.module03.question23.jta.tx.configuration;

import java.sql.SQLException;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import javax.sql.XADataSource;

import org.hsqldb.jdbc.pool.JDBCXADataSource;
import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.atomikos.jdbc.nonxa.AtomikosNonXADataSourceBean;

@Configuration
@PropertySource(value = "classpath:hibernate.properties")
@EnableJpaRepositories(basePackages = "com.spring.professional.exam.tutorial.module03.question23.jta.tx.db.employee.dao",
	entityManagerFactoryRef = "employeeEntityManager"
)
public class EmployeeDbConfiguration {
	
	@Autowired
	private Environment environment;
	
	protected static Properties properties = new Properties(); 

	@Bean
	public DataSource employeeDataSource() throws SQLException {
		
		JDBCXADataSource xaDataSource = new JDBCXADataSource();
		xaDataSource.setDatabaseName("employeedb");
		xaDataSource.setUrl("jdbc:hsqldb:mem:employeedb");
		xaDataSource.setUser("sa");
		xaDataSource.setPassword("");
		
		
		
		AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(xaDataSource);
        atomikosDataSourceBean.setUniqueResourceName("employeedb"); 
				
        return atomikosDataSourceBean;
        
        //return new EmbeddedDatabaseBuilder().setName("employeedb").setScriptEncoding("UTF-8").build();
	}
	
	/*
	@PostConstruct
	public void getDbManager(){
	   DatabaseManagerSwing.main(
		new String[] { "--url", "jdbc:hsqldb:mem:employeedb", "--user", "sa", "--password", ""});
	} */
	
	@Bean
	@Autowired
	public LocalContainerEntityManagerFactoryBean employeeEntityManager(DataSource employeeDataSource) {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		
		em.setDataSource(employeeDataSource);
		em.setPackagesToScan("com.spring.professional.exam.tutorial.module03.question23.jta.tx.db.employee.ds");
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		em.setJpaProperties(setHibernateProp());	
		
		
		return em;
	}
	

	private Properties setHibernateProp() {
		properties.put("hibernate.show_sql", environment.getProperty("show_sql"));
		properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hbm2ddl.auto"));
		properties.put("javax.persistence.transactionType", "JTA");
		return properties;
	}
}
