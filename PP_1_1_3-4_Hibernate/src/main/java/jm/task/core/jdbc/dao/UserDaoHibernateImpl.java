package jm.task.core.jdbc.dao;

import org.hibernate.SessionFactory;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {
    }
    @Override
    public void createUsersTable() {

        try (SessionFactory sessionFactory = Util.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            String createSQLTable = "CREATE TABLE IF NOT EXISTS `user` (" +
                    "  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT," +
                    "  `name` VARCHAR(45) NULL," +
                    "  `lastname` VARCHAR(45) NULL," +
                    "  `age` INT NULL," +
                    "  PRIMARY KEY (`id`));";
            session.createNativeQuery(createSQLTable).executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("Table created");
        }

    }

    @Override
    public void dropUsersTable() {
        try (SessionFactory sessionFactory = Util.getSessionFactory();
                Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            String dropSQLTable = "DROP TABLE `mydbtest1`.`user`;";
            session.createNativeQuery(dropSQLTable).executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("Table dropped");
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        SessionFactory sessionFactory = Util.getSessionFactory();
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            User user = new User(name, lastName, age);
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            System.out.println("Пользователь успешно сохранен!");
            }
    }

    @Override
    public void removeUserById(long id) {
        SessionFactory sessionFactory = Util.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            User user = session.get(User.class, id);
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
            session.close();
            System.out.println("Done!");
        }
    }

    @Override
    public List<User> getAllUsers() {
        Transaction transaction = null;
        List<User> users = new ArrayList<User>();
        try (SessionFactory sessionFactory = Util.getSessionFactory();
                Session session = sessionFactory.openSession()) {
            users = session.createQuery("from User").list();
        }

        return users;
    }

    @Override
    public void cleanUsersTable() {
        SessionFactory sessionFactory = Util.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.createNativeQuery("delete from User").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Done!");
        }

    }
}
