package com.example.iocexam.Controller;

import com.example.iocexam.Service.UserService;
import com.example.iocexam.domain.User;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void joinUser(){
        //실제로 동작할때는 user정보를 사용자로부터 정보를 받겠죠???
        User user = new User();
        user.setName("kang");
        user.setEmail("carami@gmail.com");
        user.setPassword("1111");


        userService.joinUser(user);
    }
}