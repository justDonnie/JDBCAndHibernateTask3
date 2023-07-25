package peaksoft.dao;

import org.hibernate.Session;
import peaksoft.model.User;
import peaksoft.util.Util;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        String hql = "drop table users";
        session.createNativeQuery(hql).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        session.persist(user);
        System.out.println(name+" is saved!!!");
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        User user = new User();
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        session.createQuery("delete from User");
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        List<User> users = session.createQuery("select u from User u", User.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSession().openSession();
        session.beginTransaction();
        session.createNativeQuery("delete from users").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
