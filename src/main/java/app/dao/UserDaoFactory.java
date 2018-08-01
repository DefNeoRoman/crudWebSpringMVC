package app.dao;

public class UserDaoFactory {
    public static final UserDao userDao = getConfiguredDao();

    private static UserDao getConfiguredDao() {
        UserDao userDao = new UserDaoHibernateImpl();

        return userDao;
    }

    public static UserDao getUserDao() {
        return userDao;
    }
}
