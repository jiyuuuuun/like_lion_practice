package com.example.springmvc.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class VisitController {

    @GetMapping("/visit")
    public String visit(@CookieValue(name = "lastVisit", defaultValue = "N/A") String lastVisit,
                        HttpServletResponse response, Model model) {
        //만약 로그인에 관려된 부분이면 로그인 체크를 하고 사용자가 맞다면 쿠키 생성
        model.addAttribute("lastVisit", lastVisit);
        Cookie cookie = new Cookie("lastVisit", "jiyun");
//        cookie.setDomain("/"); //쿠키가 유용한 범위 설정 --애플리케이션 전체에서 쿠키가 유효
        cookie.setMaxAge(60*60*24); //쿠키 유지 시간 (초) --하루동안 유효함

        //반드시 응답에 포함 시켜야함
        response.addCookie(cookie);

        return "visit";
    }
}
