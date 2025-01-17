package com.example.iocexam.Service;

import com.example.iocexam.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public void joinUser(User user);
}