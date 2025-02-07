package springdatajdbc02;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

@RequiredArgsConstructor
@Service
public class UserService {
    private UserDao userDao;
    private final TransactionTemplate transactionTemplate;

    @Transactional
    public void createAndUpdateUser(String username, String email, String newEmail) {
        userDao.addUser(username, email);
        if(newEmail.contains("errer")){
            throw new RuntimeException("errer");
        }
        userDao.updateUser(username, newEmail);
    }

    //TransactionTemplate을 이용해서 프로그래머가 직접 트랜잭션을 관리할 수 있다.
    public void createAndUpdateUser2(String username, String email, String newEmail) {
        transactionTemplate.execute(status -> {
            userDao.addUser(username, email);
            if (newEmail.contains("errer")) {
                throw new RuntimeException("errer");
            }
            userDao.updateUser(username, newEmail);
            return null;
        }
    );
    }
}
