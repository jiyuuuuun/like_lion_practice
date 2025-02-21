package com.example.springdatajpa4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    public CommandLineRunner demo(EmployeeRepository employeeRepository) {
        return args -> {
            //employeeRepository.findAll().forEach(employee -> log.info(employee.toString()));

            log.info("Employees in department 1 with salary between 2900 and 3100:");
            employeeRepository.findBySalaryBetween(2900.0,3100.0).forEach(employee -> log.info(employee.toString()));

            log.info("Employees in department 1 with salary between 2900 and 3100:      Fetch Join===================");
            employeeRepository.findByDepartmentIdInAndSalaryBetween(Arrays.asList(30), 2900.0, 3100.0)
                    .forEach(employee -> log.info(employee.toString()));

        };
    }
}
