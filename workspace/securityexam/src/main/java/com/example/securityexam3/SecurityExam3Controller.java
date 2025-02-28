package com.example.securityexam3;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class SecurityExam3Controller {
    private final SecurityExam3Service securityExam3Service;
    @GetMapping("/hello")
    public String home() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String message = null;
        if (authentication == null || !authentication.isAuthenticated()) {
            message = "📌로그인된 사용자가 없습니다.";
        }

            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) principal;
                message = "현재 로그인 한 사용자 : " + userDetails.getUsername();
            } else {
                message = "현재 로그인 한 사용자 pp : " + principal.toString();
            }
            return message;
        }


    @GetMapping("/abc")
    public void abc() {
        securityExam3Service.UserLog();
    }
    @GetMapping("/bbb")
    public String bbb(@AuthenticationPrincipal UserDetails userDetails) { //SecurityContextHolder에서 객체를 얻어내서 형 변환 후 주입 까지 해줌
        return"bbb"+userDetails.getUsername();
    }
    @GetMapping("/shop")
    public String shop() {
        return "FREE";
    }
    @GetMapping("/user")
    public String user() {
        return "user ONLY USER,ADMIN";
    }
    @GetMapping("/admin/abc")
    public String admin() {
        return "admin ONLY ADMIN";
    }
    @GetMapping("/admin")
    public String admin2() {
        return "admin ONLY ADMIN,SUPERUSER";
    }

}
