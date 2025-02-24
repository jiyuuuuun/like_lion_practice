package com.example.restexam.controller;

import com.example.restexam.entity.User;
import com.example.restexam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }
    @PostMapping()
    public ResponseEntity<Long> createUser(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok(user.getId());
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        User existingUser=userService.findById(id);
        if(existingUser==null) {
            return ResponseEntity.notFound().build();
        }
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        User updateUSer=userService.update(existingUser);
        return ResponseEntity.ok(updateUSer);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }


}
