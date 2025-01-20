package com.example.iocexam.Repository;

import com.example.iocexam.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserJiyunImpl implements UserDao {

    @Override
    public User getUser(String email) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return List.of();
    }

    @Override
    public void addUser(User user) {
        System.out.println(user+"의 정보를 JiyunDao가 잘 저장했습니다");

    }
}
