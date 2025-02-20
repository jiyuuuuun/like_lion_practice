package com.example.springdatajpa3;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> findUserByName(String lastName);
    List<User> findusersDynamically(String name,String email);
}
