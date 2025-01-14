package com.devcolibri.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJDBCDaoImpl extends DBService implements DaoData {
    @Override
    public void createData() throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS `mydbtest1`.`user` (\n" +
                "  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NULL,\n" +
                "  `lastname` VARCHAR(45) NULL,\n" +
                "  `age` INT NULL,\n" +
                "  PRIMARY KEY (`id`));\n";
        try (Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(createTableSQL)) {
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteData() throws SQLException {
        String query = "DROP TABLE IF EXISTS user";
        try (Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(query)) {
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void clearData() throws SQLException {
        String query = "TRUNCATE TABLE user";
        try (Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void addUser(User user) throws SQLException {
        String query = "INSERT INTO user(name, lastname, age) values(?, ?, ?)";
        try (Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getLastName());
            ps.setInt(3, (byte) user.getAge());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUserByID(int id) throws SQLException {
        String query = "delete from user where id = ?";
        try (Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> readAllData() {
        DBService dbs = new DBService();
        String query = "select * from user";
        List<User> users = new ArrayList<User>();

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet resultSet = ps.executeQuery(query);
            while (resultSet.next()) {
                users.add(new User(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("lastname"), resultSet.getByte("age")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
