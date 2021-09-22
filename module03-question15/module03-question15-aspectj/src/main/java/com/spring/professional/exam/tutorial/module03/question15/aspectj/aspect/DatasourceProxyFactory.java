package com.spring.professional.exam.tutorial.module03.question15.aspectj.aspect;

import java.lang.reflect.Proxy;

import javax.sql.DataSource;

public class DatasourceProxyFactory {
	 public static DataSource createDataSourceProxy(DataSource dataSource) {
	        return (DataSource) Proxy.newProxyInstance(
	        		DatasourceProxyFactory.class.getClassLoader(),
	                new Class[]{DataSource.class},
	                new DataSourceInvocationHandler(dataSource)
	        );
	    }
}
