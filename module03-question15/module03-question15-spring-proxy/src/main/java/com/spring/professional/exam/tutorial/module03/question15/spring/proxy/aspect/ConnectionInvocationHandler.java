package com.spring.professional.exam.tutorial.module03.question15.spring.proxy.aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

public class ConnectionInvocationHandler implements InvocationHandler {
	
	private Connection  connection;
	
	public ConnectionInvocationHandler(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Connection trace: "+method.toGenericString());
		return method.invoke(connection, args);
	}

}
