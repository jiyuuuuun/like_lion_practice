package com.example.securityexam;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //기본 설정 -- 스프링 시큐리티만 그냥 적용했을 때
//        return http
//                .authorizeHttpRequests(author -> author
//                        .anyRequest().authenticated() //모든 요청에 대해서 인증을 요구 하겠다
//                ).formLogin(Customizer.withDefaults()) //기본 로그인 화면을 쓰겠다,
//                 .build();
        //추가로 원하는 페이지는 인증없이 접근 가능, 홈 로그인 인증 방식을 사용자가 원하는 설정으로
        return http
                .authorizeHttpRequests(author -> author
                        .requestMatchers("/hello","/login").permitAll() //인증 안해도 괜찮음
                        .anyRequest().authenticated() //모든 요청에 대해서 인증을 요구 하겠다
                ).formLogin(formLogin->formLogin
                        //.loginPage("/login")//원하는 로그인 페이지 설정
                        //.defaultSuccessUrl("/success") //성공했다면?
                        .failureUrl("/fail")//실패 했다면?
                        .usernameParameter("username") //유저 이름 파라미터 이름
                        .passwordParameter("password") //패스워드 파라미터 이름
                        .loginProcessingUrl("/login_proc")// /login_proc=>시큐리티가 구현 하고 있는 기본 로그인 URL (로그인 로직) (시큐리티가 받는(POST) 컨트롤러 URL 기본값)
                        // 폼에 action 부분 여기로 설정 했어 알려주는거임/ 원하는 URL 이름으로 설정 가능
                        //커스텀으로 설정한 URL을 사용하면 시큐리티가 그 URL로 로그인 로직 구현
                        .successHandler((request, response, authentication) -> { //로그인 됐을 때 실행 설정 authentication->SecurityContext(로컬 컨텍스트) 안에 있는 정보(객체)
                            log.info("⭕Authentication successful"+authentication.getName());
                            response.sendRedirect("/success");
                        })
                        .failureHandler((request, response, exception) -> { //로그인 실패 했을 때 실행 설정
                            log.info("❌로그인 실패 ::"+exception.getMessage());
                        }))
                .logout(logout -> logout
                        .logoutUrl("/logout") //로그아웃 URL
                        .logoutSuccessUrl("/hello")//로그아웃에 성공하면 리다이렉트
                        .addLogoutHandler((request, response, authentication) -> {
                            //추가로 해야할 일
                            log.info("📌로그아웃 세션, 쿠키 삭제");
                            HttpSession session = request.getSession();
                            if(session != null) {
                                session.invalidate();
                            }
                        })
                        .deleteCookies("JSESSIONID") //로그아웃 할 때 원하는 쿠키를 삭제할 수 있음
                )

                .build();

    }
}
