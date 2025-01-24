package com.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.*;

@Controller
@RequestMapping("/exam")
public class ExamController {

    //http://localhost:8080/exam/example
    @GetMapping("/example")
    public String exaple(Model model) {
        model.addAttribute("name","jiyun");
        model.addAttribute("isAdmin",true);
        model.addAttribute("languages",new String[]{"Eng","kor","jpn"});

        return "example";
    }
    @GetMapping("/datetime")
    public String datetiem(Model model){
        model.addAttribute("currentDate", LocalDate.now());
        model.addAttribute("currentDateTime", LocalDateTime.now());
        model.addAttribute("currentTime", LocalTime.now());
        model.addAttribute("currentZonedDateTime", ZonedDateTime.now(ZoneId.of("Asia/Seoul")));
        return "datetime";
    }
}
