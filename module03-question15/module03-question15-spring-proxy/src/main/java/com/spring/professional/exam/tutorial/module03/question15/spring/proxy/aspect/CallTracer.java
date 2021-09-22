package com.spring.professional.exam.tutorial.module03.question15.spring.proxy.aspect;

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
	public Object traceCall(ProceedingJoinPoint joinPoint) {
		Object returnObject = null;
		String methodName = joinPoint.getSignature().getName();
		
		try {
			System.out.println("Starting : " +methodName);
			returnObject =  joinPoint.proceed();
		} catch (Throwable e) {
			System.out.println(String.format("Exception thrown from [%s] : [%s]",methodName,e.getMessage()));
		}
		
		System.out.println("Completed : "+ methodName);
		return returnObject;
	}
}
