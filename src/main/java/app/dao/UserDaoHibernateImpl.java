package app.dao;

import app.db.HibernateConfig;
import app.model.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private EntityManager em;

    public UserDaoHibernateImpl() {
        em = HibernateConfig.getEm();
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public User getUserByName(String name) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(int userId) {

    }

    @Override
    public List<User> getAllUsers(int offSet, int limit) {
        Query query = em.createQuery("from User ");
        query.setFirstResult(offSet);
        query.setMaxResults(limit);
        List<User> resultList = (List<User>)query.getResultList();
        return resultList;
    }

    @Override
    public User getUserById(int userId) {
        return null;
    }

    @Override
    public List<User> getLastUsers(int limit) {
        return null;
    }
}
