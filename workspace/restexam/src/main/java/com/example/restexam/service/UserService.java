package com.example.restexam.service;

import com.example.restexam.entity.User;
import com.example.restexam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();}

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }
    @Transactional
    public User update(User user) {
        if (user.getId() == null) {
            throw new IllegalArgumentException("Id is required");
        }
        User updatedUser = userRepository.findById(user.getId()).orElseThrow(() -> new IllegalArgumentException("User not found with id: " + user.getId()));

        if(user.getName() != null) {
            updatedUser.setName(user.getName());
        }
        if(user.getEmail() != null) {
            updatedUser.setEmail(user.getEmail());
        }
        return updatedUser;
    }
    @Transactional
    public void delete(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("User not found");
        }

    }



}
