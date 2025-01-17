package com.example.iocexam.Repository;

import com.example.iocexam.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    public User getUser(String email);
    public List<User> getUsers();
    public void addUser(User user);
}