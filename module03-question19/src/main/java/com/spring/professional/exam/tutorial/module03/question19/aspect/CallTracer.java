package com.spring.professional.exam.tutorial.module03.question19.aspect;

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
		
		String methodName= joinPoint.getSignature().getName();
		System.out.println("Starting method : "+methodName);
		Object returnObject = joinPoint.proceed();
		System.out.println("Completed  method : " + methodName);
		return returnObject;
		
		
		
	}
}
