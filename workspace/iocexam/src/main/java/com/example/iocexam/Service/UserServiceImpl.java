package com.example.iocexam.Service;

import com.example.iocexam.domain.User;
import com.example.iocexam.Repository.UserDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{


    private UserDao userDao;

    public UserServiceImpl(@Qualifier("userJiyunImpl") UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void joinUser(User user) {
        userDao.addUser(user);
    }
}