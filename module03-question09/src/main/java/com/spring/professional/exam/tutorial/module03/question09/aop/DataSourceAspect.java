package com.spring.professional.exam.tutorial.module03.question09.aop;

import java.lang.reflect.Proxy;
import java.sql.Connection;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DataSourceAspect {

	@Around("target(javax.sql.DataSource)")
	public Object aroundDatasource(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Data Source trace: " + joinPoint.getSignature());
		Object returnObject = joinPoint.proceed(); 
		if(returnObject instanceof Connection) {
			return createConnectionProxy((Connection)returnObject);
		} else {
			return returnObject;
		}
	}
	
	private Connection createConnectionProxy(Connection connection) {
		return (Connection)Proxy.newProxyInstance(DataSourceAspect.class.getClassLoader(), 
				new Class[] {Connection.class}, new ConnectionInvocationHandler(connection));
	}
}
