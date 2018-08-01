package app.dao;

import app.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDaoHibernateImpl implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override

    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);


    }

    @Override
    public User getUserByName(String name) {
        Query query= sessionFactory.getCurrentSession().
                createQuery("from User where name=:name");
        query.setParameter("name", name);
        return (User) query.uniqueResult();
    }

    @Override
    public void updateUser(User user) {
        User user1 = sessionFactory.getCurrentSession().get(User.class, user.getId());
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setCreatedDate(user.getCreatedDate());
        user1.setAge(user.getAge());
        sessionFactory.getCurrentSession().save(user1);
    }

    @Override
    public void deleteUser(long userId) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.byId(User.class).load(userId);
        session.delete(user);

    }

    @Override
    public List<User> getAllUsers(int offSet, int limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User ");
        query.setFirstResult(offSet);
        query.setMaxResults(limit);
        return (List<User>) query.list();
    }

    @Override
    public User getUserById(long userId) {
        return sessionFactory.getCurrentSession().get(User.class, userId);
    }

    @Override
    public List<User> getLastUsers(int limit) {
        Session session = sessionFactory.getCurrentSession();
        Query queryTotal = session.createQuery
                ("Select count(f.id) from User f");
        int countResult = (int) (long) queryTotal.getFirstResult();
        return getAllUsers(countResult - limit, limit);
    }
}
