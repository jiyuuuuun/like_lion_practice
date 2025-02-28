package com.example.securityexam2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, UserDetailsService userDetailsService) throws Exception {
        http.authorizeHttpRequests(authorizeRequests -> authorizeRequests
                .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .rememberMe(rememberMe-> rememberMe // 세션이 끝나도 유지할 수 있는 쿠키 , 별도로 쿠키가 더 생김 -> 세션 아이디 쿠키가 사라져도 유지
                                .tokenValiditySeconds(3600) //유지 시간
                .rememberMeParameter("remember-me")
                        .userDetailsService(userDetailsService)
                );

        return http.build();
    }
}
