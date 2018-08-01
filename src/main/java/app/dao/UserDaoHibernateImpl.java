package app.dao;

import app.db.HibernateConfig;
import app.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;
@Repository
public class UserDaoHibernateImpl implements UserDao {
    private EntityManager em;

    public UserDaoHibernateImpl() {
        em = HibernateConfig.getEm();
    }

    @Override
    public void addUser(User user) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
    }

    @Override
    public User getUserByName(String name) {
        User result = new User();
        result.setPassword("noPassword");
        try {
            TypedQuery<User> tq = em.createQuery("from User u WHERE u.name= :nam ", User.class);
            result = tq.setParameter("nam", name).getSingleResult();
        } catch(NoResultException | NonUniqueResultException noresult) {

        }
        return result;
    }

    @Override
    public void updateUser(User user) {
        User user1 = em.find(User.class, user.getId());
        em.getTransaction().begin();
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setCreatedDate(user.getCreatedDate());
        user1.setAge(user.getAge());
        em.persist(user1);
        em.getTransaction().commit();
    }

    @Override
    public void deleteUser(long userId) {
        User user = em.find(User.class, Long.valueOf(userId));
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();

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
    public User getUserById(long userId) {

        return em.find(User.class,userId);
    }

    @Override
    public List<User> getLastUsers(int limit) {
        Query queryTotal = em.createQuery
                ("Select count(f.id) from User f");
        int countResult = (int) (long)queryTotal.getSingleResult();
        return getAllUsers(countResult-limit,limit);
    }
}
