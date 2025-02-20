package com.example.springdatajpa4;

import com.example.springdatajpa2.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    public CommandLineRunner demo(EmployeeRepository employeeRepository) {
        return args -> {
            employeeRepository.findAll().forEach(employee -> log.info(employee.toString()));

        };
    }
}
