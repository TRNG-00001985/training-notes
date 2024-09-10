package com.revature.revshop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProductAspectLogging {
	
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	// point cut executed before all methods in service package
    @Before("execution(* com.revature.revshop.service..*(..))")
	public void beforeMethodExecution(JoinPoint joinpoint) {
		
		String methodName = joinpoint.getSignature().toShortString();
		
		Object args = joinpoint.getArgs();
		
		logger.info("before executing the method: " + methodName + "with args: "+args.toString());
		
		
	}
	
	@Around("execution(* com.revature.revshop.service..*(..))")
	public Object aroundProductServiceMethodExecution(ProceedingJoinPoint joinPoint) {
		
		String methodName = joinPoint.getSignature().toShortString();
		
		Object args = joinPoint.getArgs();
		
		Object result = null;
		
		try {
			
			result = joinPoint.proceed();
			
			
			logger.info(" executed the method: " + methodName + "with args: "+args.toString());
			
		}
		catch(Throwable e) {
			logger.error(" the method: " + methodName + "with args: "+args.toString() + "throws an execption" + e.getMessage());
			
		
		
	}
		return result;
		
	}

}
