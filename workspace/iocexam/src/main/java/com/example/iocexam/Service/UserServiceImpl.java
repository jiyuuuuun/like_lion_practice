package com.example.iocexam.Service;

import com.example.iocexam.domain.User;
import com.example.iocexam.Repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public void joinUser(User user) {
        userDao.addUser(user);
    }
}