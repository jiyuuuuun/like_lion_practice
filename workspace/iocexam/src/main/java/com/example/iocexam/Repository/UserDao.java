package com.example.iocexam.Repository;

import com.example.iocexam.domain.User;


import java.util.List;


public interface UserDao {
    public User getUser(String email);
    public List<User> getUsers();
    public void addUser(User user);
}