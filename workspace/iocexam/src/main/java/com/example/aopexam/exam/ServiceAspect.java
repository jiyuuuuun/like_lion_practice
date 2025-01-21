package com.example.aopexam.exam;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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

    @AfterReturning(pointcut = "pointcut()",returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("afterReturning :::::::::::::::::::::::::::"+joinPoint.getSignature().getName()+", return:"+result);
    }//@After 보다 먼저 실행

    @AfterThrowing(pointcut = "pointcut()",throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        System.out.println("afterThrowing::::::::::"+joinPoint.getSignature().getName());
        System.out.println("exception value"+ex.getMessage());
    }

}
