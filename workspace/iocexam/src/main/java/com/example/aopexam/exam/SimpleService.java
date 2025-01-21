package com.example.aopexam.exam;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {
    // 핵심 관심 -- 우리가 구현할 것

    public String doSomething() {
        //target
        System.out.println("SimpleService doSomething");
        return "SimpleService doSomething";
    }

    public void hello(){
        System.out.println("SimpleService hello");
        if(1==1){
            throw new RuntimeException("SimpleService hello");
        }
    }

    public void setName(String name){
        System.out.println("SimpleService setName");
    }



}
