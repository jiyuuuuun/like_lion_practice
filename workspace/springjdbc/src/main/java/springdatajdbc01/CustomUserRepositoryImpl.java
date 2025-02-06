package springdatajdbc01;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor//생성자 주입
public class CustomUserRepositoryImpl implements CustomUserRepository{
    private final NamedParameterJdbcTemplate jdbcTemplate;
    @Override
    public Page<User> findAllUsersWithpagination(Pageable pageable) {
        String sql = """
         SELECT * 
         FROM users 
         LIMIT :limit 
         OFFSET :offset
         """;

        Map<String,Object> params = new HashMap<>();
        params.put("limit",pageable.getPageSize());
        params.put("offset",pageable.getOffset());

        List<User> users= jdbcTemplate.query(sql,params,new BeanPropertyRowMapper<>(User.class));

        String countSql = "select count(*) from users";
        return PageableExecutionUtils.getPage(users,pageable,
                ()->jdbcTemplate.queryForObject(countSql,params,Long.class));
    }
}
