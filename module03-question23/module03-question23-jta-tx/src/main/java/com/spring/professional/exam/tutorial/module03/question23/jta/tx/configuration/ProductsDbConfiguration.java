package com.spring.professional.exam.tutorial.module03.question23.jta.tx.configuration;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;
import javax.sql.XADataSource;

import org.hsqldb.jdbc.pool.JDBCXADataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.atomikos.jdbc.AtomikosDataSourceBean;

@Configuration

@EnableJpaRepositories(basePackages = "com.spring.professional.exam.tutorial.module03.question23.jta.tx.db.product.dao",
		entityManagerFactoryRef = "productEntityManager" 
)
public class ProductsDbConfiguration {


	
	@Bean
	public DataSource productDataSource() throws SQLException {
		
		
		JDBCXADataSource xaDataSource = new JDBCXADataSource();
		xaDataSource.setDatabaseName("productdb");
		xaDataSource.setUrl("jdbc:hsqldb:mem:productdb");
		xaDataSource.setUser("sa");
		xaDataSource.setPassword("");
		
		
		
		AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(xaDataSource);
        atomikosDataSourceBean.setUniqueResourceName("productdb"); 
				
        return atomikosDataSourceBean;
        
        //return new EmbeddedDatabaseBuilder().setName("productdb").setScriptEncoding("UTF-8").build();
	}
	
	@Bean
	@Autowired
	public LocalContainerEntityManagerFactoryBean productEntityManager(DataSource productDataSource) {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		
		em.setDataSource(productDataSource);
		em.setPackagesToScan("com.spring.professional.exam.tutorial.module03.question23.jta.tx.db.product.ds");
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		em.setJpaProperties(EmployeeDbConfiguration.properties);
		
		return em;
	}
	
	
	
}
