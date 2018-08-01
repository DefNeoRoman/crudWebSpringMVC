package app.service;

import app.dao.UserDaoHibernateImpl;
import app.exceptions.UserAlreadyExistException;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserDaoHibernateImpl userDao;

    @Autowired
    public UserServiceImpl(UserDaoHibernateImpl userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers(int offset, int limit) {
        return userDao.getAllUsers(offset, limit);
    }
    public List<User> getLastUsers(int limit) {
        return userDao.getLastUsers(limit);
    }
    public User getUserById(long userId) {
        return userDao.getUserById(userId);
    }
    @Transactional
    public void addUser(User user) throws Exception {

        User userByName = userDao.getUserByName(user.getName());
        if(userByName == null){
            userDao.addUser(user);
        }else if(userByName.isNew()){
            userDao.addUser(user);
        }else {
            throw new UserAlreadyExistException("user already in database");
        }
    }
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    @Transactional
    public void deleteUser(long userId) {
        userDao.deleteUser(userId);
    }

    public User findUserByNameAndPassword(String userName, String password) {
        User u = userDao.getUserByName(userName);
        if (u != null && u.getPassword().equals(password)) {
            return u;
        }
        return null;
    }
    public User findUserByName(String userName) {

        return userDao.getUserByName(userName);
    }
}
