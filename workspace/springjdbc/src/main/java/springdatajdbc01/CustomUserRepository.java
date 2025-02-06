package springdatajdbc01;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomUserRepository {
    Page<User> findAllUsersWithpagination(Pageable pageable) ;

}
