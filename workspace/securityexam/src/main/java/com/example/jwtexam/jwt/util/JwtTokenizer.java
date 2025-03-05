package com.example.jwtexam.jwt.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtTokenizer {
    private final byte[] accessSecret;
    private final byte[] refreshSecret;


    public static final Long ACCESS_TOKEN_EXPIRES_COUNT = 30*60*1000L; //유지시간 30분
    public static final Long REFRESH_TOKEN_EXPIRES_COUNT =7*24*60*60*1000L; //유지시간 7일

    public JwtTokenizer(@Value("${jwt.secretKey") String accessSecret, @Value("${jwt.refreshKey") String refreshSecret) {
        this.accessSecret = accessSecret.getBytes(StandardCharsets.UTF_8);
        this.refreshSecret = refreshSecret.getBytes(StandardCharsets.UTF_8);
    }

    private String createToken(Long id, String email, String name, String username, List<String> roles,Long expire, byte[] secretKey) {
        Claims claims=Jwts.claims().setSubject(email);
        //필요한 정보들을 저장
        claims.put("username", username);
        claims.put("roles", roles);
        claims.put("userId", id);
        claims.put("name", name);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+expire))//expire 1000*60*60 1시간
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .signWith(getSigningKey(secretKey))
                .compact();

    }

    private static Key getSigningKey(byte[] secretkey){
        return Keys.hmacShaKeyFor(secretkey);
    }

    public String createAccessToken(Long id, String email, String name, String username, List<String> role){
        return createToken(id,email,name,username,role,ACCESS_TOKEN_EXPIRES_COUNT,accessSecret);
    }
    public String createRefreshToken(Long id, String email, String name, String username, List<String> role){
        return createToken(id,email,name,username,role,REFRESH_TOKEN_EXPIRES_COUNT,refreshSecret);
    }
}
