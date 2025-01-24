package com.example.springmvc.controller;

import com.example.springmvc.domain.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("register")
    public String registerForm(Model model){
        model.addAttribute("user", new User());
        return "registerForm";
    }
    @PostMapping("register")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult result){
        if(result.hasErrors())
            return "registerForm";
        return "result";
    }
}
