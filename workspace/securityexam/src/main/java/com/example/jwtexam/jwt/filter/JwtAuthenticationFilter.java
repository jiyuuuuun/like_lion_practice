package com.example.jwtexam.jwt.filter;


import com.example.jwtexam.jwt.token.JwtAuthenticationToken;
import com.example.jwtexam.jwt.util.JwtTokenizer;
import com.example.jwtexam.security.dto.CustomUserDetails;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtTokenizer jwtTokenizer;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = getTokenFromRequest(request);
        if(StringUtils.hasText(token)){
            try{
                Authentication authentication=getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);

            }catch (Exception e){
                log.error("JWT Filter - Internal Error : {}", token,e);
                SecurityContextHolder.clearContext();
                throw new BadCredentialsException("JWT Filter - Internal Error");
            }
        }

        filterChain.doFilter(request, response);
    }
    private String getTokenFromRequest(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (StringUtils.hasText(authorization) && authorization.startsWith("Bearer ")) {
            return authorization.substring(7);
        }

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("access_token")) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
    private Authentication getAuthentication(String token) {
        Claims claims=jwtTokenizer.parseAccessToken(token);
        String email=claims.getSubject();
        Long userId=claims.get("userId",Long.class);
        String name=claims.get("name",String.class);
        String username=claims.get("username",String.class);

        List<GrantedAuthority> grantedAuthorities=getGrantedAuthorities(claims);

        CustomUserDetails customUserDetails=new CustomUserDetails(username,"",name,grantedAuthorities);
        return new JwtAuthenticationToken(grantedAuthorities,customUserDetails,null);




    }
    private List<GrantedAuthority> getGrantedAuthorities(Claims claims) {
        List<String> roles=(List<String>) claims.get("roles", List.class);
        return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

    }

}
