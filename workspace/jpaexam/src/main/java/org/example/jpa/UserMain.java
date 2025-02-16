package org.example.jpa;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j//로그를 쓰겠다
public class UserMain {
    //private static final Logger log = LoggerFactory.getLogger(UserMain.class); //Lombok 사용 안할 시
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        User user = new User("John", "Doe@example.com");
        //createUser
        dao.createUser(user);

        //findUser
        User user1=dao.findUser(user.getId());
        //System.out.println(user1);  코드들은 실제 동작할 때 다 빠져야함 -> 어플리케이션의 성능을 떨어뜨림
        log.info("find user:{}",user1); //로그를 사용하면 이 코드를 뺄 때 편리함(로그 레벨)

        //updateUser
        user.setName("jun");
        dao.updateUser(user);
        log.info("update user:{}",user);

        //deleteUser
        User user2=dao.findUser(user.getId());
        dao.deleteUser(user2);
        log.info("delete user:{}",user2);


    }
}
