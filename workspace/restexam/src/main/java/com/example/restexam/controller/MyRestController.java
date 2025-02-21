package com.example.restexam.controller;

import com.example.restexam.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MyRestController {
    @GetMapping("/api/greeting")
    public Map<String,String> greeting(@RequestParam(name="message",required = false,defaultValue = "world") String message) {
        Map<String,String> map = new HashMap<>();
        map.put("hello",message);
        return map;
    }
    @GetMapping("/api/user")
    public User user(@RequestParam(name = "name",required = false,defaultValue ="jiyun")String name) {
        return new User();
    }
    @GetMapping("/api/users")
    public List<User> users() {
        List<User> users = new ArrayList<>();

        return users;

    }

}
