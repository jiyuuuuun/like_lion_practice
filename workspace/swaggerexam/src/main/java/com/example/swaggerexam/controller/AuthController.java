package com.example.swaggerexam.controller;

import com.example.swaggerexam.dto.LoginRequestDTO;
import com.example.swaggerexam.dto.RegisterRequestDTO;
import com.example.swaggerexam.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Operation(
            summary = "회원가입",
            description = "이메일과 비밀번호를 입력하여 회원가입을 합니다"
    )
    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequestDTO registerRequestDTO) {

        return ResponseEntity.ok("Hello World");
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO requestDTO) {
        return ResponseEntity.ok("로그인 성공");
    }
    @GetMapping("/logout")
    public ResponseEntity<?> logout(@Parameter(description = "JWT 인증 토큰",required = true,example = "Bearer eyJhbGRoiIusrt...")
                                        @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok("로그아웃 성공");
    }
    @Operation(summary = "사용자 목록 조회", description = "사용자 목록을 페이지 단위로 조회합니다.")
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
//        List<UserDto> users = userService.getUsers(page, size);
        return ResponseEntity.ok(null);
    }

}
