package com.spring.professional.exam.tutorial.module03.question18.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CallTracer {

	@Pointcut("within(com..service.*)")
	public void callTraceComponentPointcut() {
		
	}
	
	@Around("callTraceComponentPointcut()")
	public Object traceCall(ProceedingJoinPoint joinPoint) throws Throwable {
		
		
		 String methodName = joinPoint.getSignature().getName();

	        System.out.println("Starting " + methodName);
	        Object returnValue = joinPoint.proceed();

	        System.out.println("Completed " + methodName);
	        return returnValue;
	        
		/*
		Object returnObject = null;
		String methodName = joinPoint.getSignature().getName();
		
		try {
			System.out.println("Starting method : " + methodName);
			returnObject = joinPoint.proceed();
		} catch (Exception e) {
			System.out.println(String.format("Exception thrown while executing [%s] : [%s]", methodName,e.getMessage()));
		}
		
		System.out.println("Completed method : "+ methodName);
		
		return returnObject;*/
		
	}
}
