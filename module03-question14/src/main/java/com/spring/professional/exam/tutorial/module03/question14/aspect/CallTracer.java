package com.spring.professional.exam.tutorial.module03.question14.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CallTracer {

	@Pointcut("within(com..dao.*)||within(com..service.*)")
	public void callTraceComponentsPointcut() {
		
	}
	
	@Around("callTraceComponentsPointcut()")
	public Object traceCall(ProceedingJoinPoint joinPoint) {
		Object returnvalue = null; 
		String methodName = joinPoint.getSignature().getName();
		
		try {
			System.out.println("Starting : " + methodName);
			returnvalue = joinPoint.proceed();
		} catch (Throwable throwable) {
			System.out.println(String.format("Exception thrown from %s : %s",methodName, throwable.getMessage()));
		}
		
		System.out.println("Completed : "+ methodName);
		return returnvalue;
	}
}
