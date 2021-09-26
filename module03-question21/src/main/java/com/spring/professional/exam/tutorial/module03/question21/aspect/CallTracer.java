package com.spring.professional.exam.tutorial.module03.question21.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CallTracer {
	
	@Pointcut("within(com..service.*)")
	public void serviceClassMethodTrace() {
		
	}
	
	@Around("serviceClassMethodTrace()")
	public Object tarceCall(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println();
		System.out.println();
		System.out.println("Starting method call : " + joinPoint.getSignature());
		Object returnObjet = joinPoint.proceed();
		System.out.println("Ending method call : " + joinPoint.getSignature());
		return returnObjet;
	}

}
