package springdatajdbc02;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(UserDao userDao,UserService userservice) {
        return args -> {
            //userDao.createAndUpdateUser("lion6","lion6@email","error");
            userservice.createAndUpdateUser("jiyun","jiyun@email","errerjiyun@email");


        };
    };
}
