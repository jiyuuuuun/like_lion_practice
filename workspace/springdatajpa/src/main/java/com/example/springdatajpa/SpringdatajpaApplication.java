package com.example.springdatajpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Slf4j
@SpringBootApplication
public class SpringdatajpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(UserRepository userRepository) {
		return args -> {
			//create
			User user = new User("hong","hong@gmail.com");
			User user2 = new User("hong2","hong2@gmail.com");
			userRepository.save(user);
			userRepository.save(user2);
			log.info("User saved: "+user);
			log.info("User saved: "+user2);

			//delete
			User user3 = userRepository.findById(1L).get();
			userRepository.delete(user3);

			//update
			User user4 = userRepository.findById(2L).get();
			user4.setEmail("hwang@gmail.com");
			user4.setName("hwang");
			userRepository.save(user4);
			log.info("User update: "+user4);

			userRepository.findAll().forEach(usern -> log.info("User found: "+usern));

			List<User> users = userRepository.findByUsername("hong");
			users.forEach(System.out::println);

			List<User> users2 = userRepository.findByNameContaining("hong");

			List<User> users3 = userRepository.findByNameAndEmail("hong","hong@gmail.com");

			List<User> users4 = userRepository.selectUser("hong");

			List<User> users5 = userRepository.selectUserLikeName("hong");

			Pageable pageable = PageRequest.of(0, 2);
			userRepository.findByNameContaining("hong",pageable).forEach(userx -> log.info(userx.toString()));

			userRepository.findAll(pageable).forEach(userx -> log.info(userx.toString()));
		};
	}
}
