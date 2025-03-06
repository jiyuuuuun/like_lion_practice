package com.example.jwtexam.test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;


public class JWTExample {
    public static void main(String[] args) {
        String secret = "abcdefghijklmnopqrstuvwxzy123456";
        byte[] bytes=secret.getBytes(StandardCharsets.UTF_8);
        SecretKey secretKey=Keys.hmacShaKeyFor(bytes);

        //JWT 생성
        String token= Jwts.builder()
                .setIssuer("jun-app")
                .setSubject("jun123")
                .setExpiration(new Date(System.currentTimeMillis()+35000))
                .claim("role","ADMIN")
                .signWith(secretKey)
                .compact();

        System.out.println(token);

        //JWT 파싱,검증
       Claims claims=Jwts.parserBuilder()
               .setSigningKey(secretKey)
               .build()
               .parseClaimsJws(token)
               .getBody();

        System.out.println(claims.getExpiration());
        System.out.println(claims.getSubject());
        System.out.println(claims.getAudience());






    }
}
