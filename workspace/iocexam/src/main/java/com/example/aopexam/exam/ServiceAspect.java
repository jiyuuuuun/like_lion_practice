package com.example.aopexam.exam;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
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
    @Around("pointcut()")
    public String around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around :::::::::::::::::::: 실제 메서드가 실행되기 전에 해야할 것이 있다면 여기");

        String value=(String) joinPoint.proceed(); //실제 Target의 메소드를 호출 -- 이 줄을 기준으로 윗부분과 아랫부분의 시점이 달라짐

        System.out.println("Around :::::::::::::::::::::::::::::");

        value+="   jiyun aop run!!";

        return value;
    }

}
