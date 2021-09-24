package com.spring.professional.exam.tutorial.module03.question19.aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ConnectionInvocationHandler implements InvocationHandler {
	
	private Connection connection;
	
	private static Set<String> LOGGABLE_METHODS = new HashSet<String>(Arrays.asList("rollback","commit","close"));
	
	public ConnectionInvocationHandler(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(shouldLogMessage(method)) {
			System.out.println("Connection trace: " + method.toGenericString());
		}
		
		return method.invoke(connection, args);
	}
	
	private boolean shouldLogMessage(Method method) {
		return LOGGABLE_METHODS.contains(method.getName());
	}

}
