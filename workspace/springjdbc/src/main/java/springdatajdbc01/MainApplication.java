package springdatajdbc01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

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
            userRepository.save(new User("jiyun", "jiyun@gmail.com"));
            userRepository.findAll().forEach(System.out::println);

            PageRequest pageRequest = PageRequest.of(0, 3);

            System.out.println("=======================");
            Page<User> page= userRepository.findAllUsersWithpagination(pageRequest);
            page.forEach(System.out::println);

        };
    }
    @Bean
    public CommandLineRunner batchUpdateDemo(JdbcTemplate jdbcTemplate){
        return args -> {
            List<User> users = Arrays.asList(
                    new User("kang","kang@exam.com"),
                    new User("kim","kim@exam.com"),
                    new User("hong","hong@exam.com"),
                    new User("lee","lee@exam.com"),
                    new User("aaa","aaa@exam.com")
            );

            //여러건을 한번에 입력하는 작업을 수행.
            String sql = "INSERT INTO users(name,email) VALUES(?,?)";
            jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    User user = users.get(i);
                    ps.setString(1, user.getName());
                    ps.setString(2,user.getEmail());
                }

                @Override
                public int getBatchSize() {
                    return users.size();
                }
            });
        };
    }
}
