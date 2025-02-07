package springdatajdbc01;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 구현체에 @Repository 붙이지만 명시적으로 표현하기 위해 붙임
public interface UserRepository extends CrudRepository<User, Long>,CustomUserRepository {
    List<User> findByName(String name);
}
