package com.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    //http://localhost:8080/greeting?name=jiyun
    @GetMapping("/greeting")
    public ModelAndView greet(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        //name 파라미터를 받아옴 required->필수 값인가? 값이 없을 경우 기본값은 "World"
        ModelAndView mav = new ModelAndView("greeting");
        mav.addObject("name", name);
        return mav;
    }

    @GetMapping("/users/{userId}") //http://localhost:8080/users/carami   -- {userId} 는 값이들어올거다라는 의미.
    public String getUser(@PathVariable("userId") String userId, Model model){
        System.out.println(userId);
        model.addAttribute("userId",userId);
        return "userView";
    }


}
