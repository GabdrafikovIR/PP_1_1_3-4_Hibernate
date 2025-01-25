package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    //конфигурация подключения jbdc
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest1";
    private static final String USER = "root";
    private static final String PASSWORD = "Ehecce1002!";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }


    //Конфигурация подключения Hibernate
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        try {
            // Создаем конфигурацию Hibernate
            Configuration configuration = new Configuration();

            // Устанавливаем параметры конфигурации
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/mydbtest1");
            configuration.setProperty("hibernate.connection.username", "root");
            configuration.setProperty("hibernate.connection.password", "Ehecce1002!");
            configuration.setProperty("hibernate.hbm2ddl.auto", "update");
            configuration.setProperty("hibernate.current_session_context_class", "thread");

            // Создаем SessionFactory из конфигурации
            sessionFactory = configuration
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
            return sessionFactory;
        } catch (Throwable ex) {
            // Если возникла ошибка создания SessionFactory
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

}