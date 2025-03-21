package springdatajdbc01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

//DTO - 단순하게 값만 담아서 전달되는 객체
//엔티티 - DTO의 역할도 하지만, 데이터베이스와 객체 간의 관계를 알려주는 역할도 함

@Table("users")
@Setter
@Getter
@NoArgsConstructor //매개변수 없는 생성자
@AllArgsConstructor //모든 매개변수가 들어있는 생성자
public class User {
    @Id
    private Long id;
    private String name;
    private String email;

    public User(String name,String email) {
        this.email = email;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
