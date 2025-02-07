package springdatajdbc02;

public interface UserDao {
    void createAndUpdateUser(String username, String email, String newEmail);
    void addUser(String username, String email);
    void updateUser(String username, String email);
}
