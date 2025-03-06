package com.example.jwtexam.controller;

import com.example.jwtexam.domain.RefreshToken;
import com.example.jwtexam.dto.UserLoginResponseDTO;
import com.example.jwtexam.jwt.util.JwtTokenizer;
import com.example.jwtexam.security.dto.UserLoginDTO;
import com.example.jwtexam.service.RefreshTokenService;
import com.example.jwtexam.service.UserService;
import com.example.jwtexam.domain.Role;
import com.example.jwtexam.domain.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserApiController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenizer jwtTokenizer;
    private final RefreshTokenService refreshTokenService;

    @GetMapping("/info")
    public String info() {
        return "info";
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDTO> login(@RequestBody UserLoginDTO userLoginDTO, HttpServletResponse response) {
        User user=userService.findByUsername(userLoginDTO.getUsername());
        log.info("login username:{}",userLoginDTO.getUsername());
        if(user==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(!passwordEncoder.matches(userLoginDTO.getPassword(),user.getPassword())) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        List<String> roles=user.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toList());

        String accessToken=jwtTokenizer.createAccessToken(user.getId(), user.getEmail(), user.getName(), user.getUsername(), roles);
        String refreshToken= jwtTokenizer.createRefreshToken(user.getId(), user.getEmail(), user.getName(), user.getUsername(), roles);

        RefreshToken refreshToken1=new RefreshToken();
        refreshToken1.setUserId(user.getId());
        refreshToken1.setValue(refreshToken);

        refreshTokenService.save(refreshToken1);

        //쿠키는 필수 아님
        Cookie accessTokenCookie=new Cookie("access_token",accessToken);
        accessTokenCookie.setHttpOnly(true);
        accessTokenCookie.setPath("/");
        accessTokenCookie.setMaxAge(Math.toIntExact(jwtTokenizer.ACCESS_TOKEN_EXPIRES_COUNT/1000)); //LONG값을 INT로 바꾸어서 안전하게

        Cookie refreshTokenCookie=new Cookie("refresh_token",refreshToken);
        refreshTokenCookie.setHttpOnly(true);
        refreshTokenCookie.setPath("/");
        refreshTokenCookie.setMaxAge(Math.toIntExact(jwtTokenizer.REFRESH_TOKEN_EXPIRES_COUNT/1000));

        response.addCookie(accessTokenCookie);
        response.addCookie(refreshTokenCookie);

        UserLoginResponseDTO userLoginResponseDTO=UserLoginResponseDTO.builder()
                .name(user.getName())
                .userID(user.getId().toString())
                .access_token(accessToken)
                .refresh_token(refreshToken)
                .build();

        return ResponseEntity.ok(userLoginResponseDTO);

    }
}
