package com.spring.professional.exam.tutorial.module03.question15.aspectj.aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

import javax.sql.DataSource;

public class DataSourceInvocationHandler implements InvocationHandler {
	
	private DataSource dataSource;
	
	public DataSourceInvocationHandler(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object retruObject = method.invoke(dataSource, args);
		
		if(method.getName().equals("getConnection")) {
			System.out.println("Data Source Trace: " + method.toGenericString());
		}
		
		if(retruObject instanceof Connection) {
			return createConnectionProxy((Connection)retruObject);
		} else {
			return retruObject;
		}
	
	}
	
	private Connection createConnectionProxy(Connection connection) {
		return (Connection)Proxy.newProxyInstance(DatasourceProxyFactory.class.getClassLoader(), 
				new Class[] {Connection.class}, new ConnectionInvocationHandler(connection));
	}

}
