package com.example.aopexam.exam;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Pointcut("execution(* com.example.aopexam.exam.SimpleService.*(..))")
    public void pointcut() {

    }
    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("Before Method:::::::::::::::::::::::"+joinPoint.getSignature().getName());
    }
    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("after Method:::::::::::::::::::::::"+joinPoint.getSignature().getName());
    }

}
