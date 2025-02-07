package springdatajdbc02;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Repository
public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;
    @Transactional
    @Override
    public void createAndUpdateUser(String name, String email, String newEmail) {
        jdbcTemplate.update("INSERT INTO users(name,email) VALUES (?,?)", name, email);

        if(newEmail.contains("error")) {
            throw new RuntimeException("error");
        }

        jdbcTemplate.update("UPDATE users SET email = ? where name = ?", newEmail, name);

    }
    @Transactional
    @Override
    public void addUser(String name, String email) {
        jdbcTemplate.update("INSERT INTO users(name,email) VALUES (?,?)", name, email);
    }
    @Transactional
    @Override
    public void updateUser(String name, String email) {
        jdbcTemplate.update("UPDATE users SET email = ? where name = ?", email, name);
    }
}
