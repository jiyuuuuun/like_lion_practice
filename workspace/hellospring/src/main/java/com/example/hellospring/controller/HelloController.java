package com.example.hellospring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hi(){
        return "hello Spring";
    }

    @GetMapping("/")
    public String hi_second(){
        return "hi";
    }


}
