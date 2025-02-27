package com.example.beforesecurity;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@Order(1)
public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            log.info("📌UserFilter doFilter 실행 전" + Thread.currentThread().getName());

            String name = (String) servletRequest.getParameter("name");
            // 쓰레드 로컬에 저장하고 싶은 객체가 존재 할 시
            UserContext.setUser(new User(name));

            // ✅ 필터 체인 실행 (여기서 컨트롤러, 서비스 등 실행됨)
            filterChain.doFilter(servletRequest, servletResponse);
            log.info("📌UserFilter doFilter 실행 후" + Thread.currentThread().getName());
        }finally {
            // ✅ 요청이 끝난 후 ThreadLocal에서 User 객체 삭제 (쓰레드 풀에서 재사용 해야함)
            UserContext.removeUser();
        }
    }
}
