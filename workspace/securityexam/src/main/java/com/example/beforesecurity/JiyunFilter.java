package com.example.beforesecurity;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
//@Component
//@Order(2)
//@WebFilter(urlPatterns = "/*") 모든 요청
public class JiyunFilter implements Filter {

    @Override
    public void init(jakarta.servlet.FilterConfig filterConfig) throws ServletException {
        log.info("📌JiyunFilter init()");

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("📌JiyunFilter doFilter() 실행 전"+Thread.currentThread().getName());
        filterChain.doFilter(servletRequest, servletResponse); //수행하고 다음으로 넘김
        log.info("📌JiyunFilter doFilter() 실행 후"+Thread.currentThread().getName());
    }
    @Override
    public void destroy() {
        log.info("📌JiyunFilter destroy()");

    }
}
