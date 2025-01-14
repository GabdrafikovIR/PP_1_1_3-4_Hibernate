package com.devcolibri.db;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        List<User> users = new ArrayList<User>();
        DaoData dao = new UserJDBCDaoImpl();
        dao.createData();
        dao.addUser(new User("Mixail", "Kutuzov", (byte) 66));
        dao.addUser(new User("Tanya", "Trinova", (byte) 32));
        dao.addUser(new User("Kostya", "Cherbatov", (byte) 37));
        dao.addUser(new User("Petr", "Kruglov", (byte) 46));
        dao.deleteUserByID(2);
        dao.readAllData();

        System.out.println(dao.readAllData());
    }
}