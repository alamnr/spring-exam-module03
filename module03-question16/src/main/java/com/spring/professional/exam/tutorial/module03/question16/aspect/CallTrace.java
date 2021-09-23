package com.spring.professional.exam.tutorial.module03.question16.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CallTrace {

	@Pointcut("within(com..service.*)")
	public void callTraceComponentsPointcut() {
		
	}
	
	@Around("callTraceComponentsPointcut()")
	public Object traceCall(ProceedingJoinPoint joinPoint) {
		Object returnValue = null;
		String methodName = joinPoint.getSignature().getName();
		
		try {
			System.out.println("Starting : "+ methodName);
			returnValue = joinPoint.proceed();
		} catch (Throwable e) {
			System.out.println(String.format("Exception thrown from [%s] : [%s] ",methodName, e.getMessage()));
		}
		
		System.out.println("Completed : "+methodName);
		return returnValue;
	}
}
