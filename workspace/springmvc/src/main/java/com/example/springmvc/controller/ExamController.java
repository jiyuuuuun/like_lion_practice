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
import java.util.Arrays;
import java.util.List;

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
            return "form";  //유효성 검사 실패했을 때 다시 폼뷰로 리턴
        }
//        return "result";  //성공 시 결과 페이지로 포워딩
        return "redirect:/exam/datetime";
    }

    @GetMapping("/list")
    public String showList(Model model){
        List<String> items = Arrays.asList("Item 1", "Item 2", "Item 3", "Item 4", "Item 5",
                "Item 6", "Item 7", "Item 8", "Item 9", "Item 10");
        model.addAttribute("items", items);
        return "list";
    }
}
