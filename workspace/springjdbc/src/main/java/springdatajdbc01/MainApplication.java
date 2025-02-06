package springdatajdbc01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//
//    }
    @Bean //CommandLineRunner를 빈으로 등록해 놓으면 자동으로 실행
    public CommandLineRunner demo(UserRepository userRepository) {
        return args -> {
            //DB와 접속해서 일하는 프레임 워크는 Spring JDBC, Mybatis, JPA
            //Spring data JDBC -- 위에서 나열한 프레임워크를 표준화 시켜주는  프레임워크
            userRepository.save(new User("jiyun@gmail.com", "jiyun"));
            userRepository.findAll().forEach(System.out::println);

        };
    }
}
