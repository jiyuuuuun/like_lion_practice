package com.example.securityex4.controller;


import com.example.securityex4.domain.User;
import com.example.securityex4.domain.UserRegisterDTO;
import com.example.securityex4.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/signup")
    public String signup() {
        return "exam4/users/signup";
    }
    @PostMapping("/userreg")
    public String signup(@ModelAttribute UserRegisterDTO userRegisterDTO) {
        log.info("signup user: {}", userRegisterDTO);
        if(userService.existUser(userRegisterDTO)) {
            log.info("signup user already exist: {}", userRegisterDTO);
            return "exam4/users/signup-error";
        }
        userService.registUser(userRegisterDTO);
        log.info("signup");
        return "redirect:/loginform";
    }
    @GetMapping("/loginform")
    public String loginform() {
        return "exam4/users/loginform";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/myinfo")
    public String myinfo() {
        return "exam4/myinfo";
    }

}
