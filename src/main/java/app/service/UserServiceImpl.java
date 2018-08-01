package app.service;

import app.dao.UserDaoHibernateImpl;
import app.exceptions.UserAlreadyExistException;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoHibernateImpl userDao;

    public List<User> getAllUsers(int offset, int limit) {
        return userDao.getAllUsers(offset, limit);
    }
    public List<User> getLastUsers(int limit) {
        return userDao.getLastUsers(limit);
    }
    public User getUserById(long userId) {
        return userDao.getUserById(userId);
    }

    public void addUser(User user) throws Exception {
        User userByName = userDao.getUserByName(user.getName());
        if(userByName.isNew()){
            userDao.addUser(user);
        }else {
            throw new UserAlreadyExistException("user already in database");
        }
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

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
}
