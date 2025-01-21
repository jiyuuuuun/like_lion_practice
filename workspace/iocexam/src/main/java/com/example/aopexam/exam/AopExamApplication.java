package com.example.aopexam.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopExamApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(AopExamApplication.class, args);
    }

    @Autowired
    private SimpleService simpleService;

    @Override
    public void run(String... args) throws Exception {
        simpleService.doSomething();
        simpleService.hello();
        simpleService.setName("jiyun");

    }
}
