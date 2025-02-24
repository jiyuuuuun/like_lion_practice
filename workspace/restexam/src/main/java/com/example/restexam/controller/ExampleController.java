package com.example.restexam.controller;

import com.example.restexam.entity.User;
import com.example.restexam.repository.UserRepository;
import com.example.restexam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExampleController {

    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("/example")
    public ResponseEntity<String> getExample(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Custom-Header", "carami")
                .body("Hello!!");
    }


//    @GetMapping("/users/{id}")
//    public ResponseEntity<User> user(@PathVariable("id") Long id) {
//        User user = userService.findById(id);
//        if(user==null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(user);
//
//    }

}
