package com.example.springmvc.controller;

import com.example.springmvc.domain.UserForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping("/submitForm")
    public String submitForm(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult result){
        if(result.hasErrors()){
            return "form";  //유효성 검사 실패했을 때 다시 폼뷰초 리턴
        }

        return "result";  //성공 시 결과 페이지로 리다이렉트
    }
}
