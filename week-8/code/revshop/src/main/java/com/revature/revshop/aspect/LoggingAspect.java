package com.revature.revshop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // Pointcut to match all methods in UserService
    @Before("execution(* com.revature.revshop.service..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        // log the method and its arguments
        String methodName = joinPoint.getSignature().toString();
        Object[] args = joinPoint.getArgs();
        logger.info("Starting method: {} with arguments: {}", methodName, args);
    }

     //Around advice to log method result
    @Around("execution(* com.revature.revshop.service.UserService.*(..))")
    public Object logAroundAnyService(ProceedingJoinPoint joinpoint) {
    	String methodName = joinpoint.getSignature().toString();
    	
    	Object args = joinpoint.getArgs();
    	
    	Object result = null;
    	
    	try {
    		result = joinpoint.proceed();
    		
    		logger.info("executed " + methodName + "successfully with "+ args );
    	}
    	catch(Throwable t) {
    		
    		logger.error( methodName + "with "+ args +"trows exception" + t.getMessage());
    		
    	}
    	
    	return result;
    	
    	
    }

    // Log exceptions thrown by UserService methods
    @AfterThrowing(pointcut = "execution(* com.revature.revshop.service.UserService.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Exception exception) {
        String methodName = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();
        logger.error("Exception thrown in method: {} with arguments: {}. Exception: {}", methodName, args, exception.getMessage());
    }
    

}
