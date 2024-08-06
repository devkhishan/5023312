package com.library.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect{
    private long startTime;

    @Before("execution(* com.library..*(..))")
    public void startLog(JoinPoint joinPoint){
        startTime = System.currentTimeMillis();
//        System.out.println("Starting Execution : "+joinPoint.getSignature());
        System.out.println("Before Method : "+joinPoint.getSignature().getName());
    }


    @After("execution(* com.library..*(..))")
    public void endLog(JoinPoint joinPoint){
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
//        System.out.println("Ending Execution : "+joinPoint.getSignature());
//        System.out.println("Total Execution : "+executionTime);
        System.out.println("After Method : "+joinPoint.getSignature().getName());
    }
}