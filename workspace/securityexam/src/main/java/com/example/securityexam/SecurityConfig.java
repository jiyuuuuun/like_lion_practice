package com.example.securityexam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //기본 설정
//        return http
//                .authorizeHttpRequests(author -> author
//                        .requestMatchers("/hello","/loginForm").permitAll() //인증 안해도 괜찮음
//                        .anyRequest().authenticated() //모든 요청에 대해서 인증을 요구 하겠다
//                ).formLogin(Customizer.withDefaults()) //기본 로그인 화면을 쓰겠다,
//                 .build();
        //추가로 원하는 페이지는 인증없이 접근 가능, 홈 로그인 인증 방식을 사용자가 원하는 설정으로
        return http
                .authorizeHttpRequests(author -> author
                        .requestMatchers("/hello","/loginForm").permitAll() //인증 안해도 괜찮음
                        .anyRequest().authenticated() //모든 요청에 대해서 인증을 요구 하겠다
                ).formLogin(formLogin->formLogin
                        .loginPage("/loginForm")//원하는 로그인 페이지 설정
                        .defaultSuccessUrl("/success") //성공했다면?
                        .failureUrl("/fail")//실패 했다면?
                        .usernameParameter("username") //유저 이름 파라미터 이름
                        .passwordParameter("password") //패스워드 파라미터 이름

                )
                .build();

    }
}
