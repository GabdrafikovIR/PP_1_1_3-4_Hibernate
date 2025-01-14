package com.devcolibri.db;

import java.sql.SQLException;
import java.util.List;

public interface DaoData {
    void createData () throws SQLException;
    void deleteData () throws SQLException;
    void clearData () throws SQLException;
    void addUser (User user) throws SQLException;
    void deleteUserByID (int id) throws SQLException;
    <T> List<T> readAllData();
}
