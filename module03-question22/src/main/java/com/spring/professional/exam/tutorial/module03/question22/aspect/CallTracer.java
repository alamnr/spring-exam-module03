package com.spring.professional.exam.tutorial.module03.question22.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CallTracer {

	@Pointcut("within(com..service.*)")
	public void serviceMethodPointcut() {
		
	}
	
	@Around("serviceMethodPointcut()")
	public Object traceCall(ProceedingJoinPoint joinPoint) throws Throwable {
		
		System.out.println();
		System.out.println("Starting method call "+joinPoint.getSignature().getName());
		Object returnObject = joinPoint.proceed();
		
		System.out.println("Ending method call : " +joinPoint.getSignature().getName());
		return returnObject;
		
	}
}
