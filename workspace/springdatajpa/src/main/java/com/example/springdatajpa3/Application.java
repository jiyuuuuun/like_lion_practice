package com.example.springdatajpa3;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        //userRepository.findAll().forEach(user -> log.info(user.toString()));
        userRepository.findUserByName("John").forEach(user -> log.info(user.getName()));
        userRepository.findusersDynamically("John",null).forEach(user -> log.info("user :: {} {}",user.getName(),user.getEmail()));

    }
}
