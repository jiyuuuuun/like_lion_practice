package com.example.securityexam3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/hello","shop/**","/abc","userinfo","/img/**","/static/**").permitAll() //permitAll() -> 인증 안 해도 사용하게 해줌
                        .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN") // /User로 시작하는 URL은 USER랑 ADMIN 만 접속 가능
                        .requestMatchers("/admin/abc").hasRole("ADMIN")
                        .requestMatchers("/admin/**").hasAnyRole("ADMIN", "SUPERUSER")
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin->formLogin
                        .defaultSuccessUrl("/hello")
                        .failureUrl("/login?error")
                )

                .logout(logout -> logout
                        .logoutUrl("/logout")
                .logoutSuccessUrl("/hello")
                );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("jiyun")
                .password(passwordEncoder.encode("jiyun1021")) //패스워드를 암호화 해서 넣음
                .roles("USER").build();
        UserDetails user2 = User.withUsername("kong")
                .password(passwordEncoder.encode("kong0512")) //패스워드를 암호화 해서 넣음
                .roles("USER","ADMIN").build();
        UserDetails user3=User.withUsername("superUser")
                .password(passwordEncoder.encode("1234")) //패스워드를 암호화 해서 넣음
                .roles("SUPERUSER").build();
        UserDetails user4=User.withUsername("admin")
                .password(passwordEncoder.encode("1234")) //패스워드를 암호화 해서 넣음
                .roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user,user2,user3,user4); //메모리에 있는 유저들을 UserDetailsService에 저장
    }

    @Bean
    public PasswordEncoder passwordEncoder() { //비밀번호 암호화
        return new BCryptPasswordEncoder();
    }

}

//USER,ADMIN,SUPERUSER