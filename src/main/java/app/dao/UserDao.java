package app.dao;

import app.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);
    User getUserByName(String name);
    void updateUser(User user);
    void deleteUser(long userId);
    List<User> getAllUsers(int offSet, int limit);
    User getUserById(long userId);
    List<User> getLastUsers(int limit);

}
