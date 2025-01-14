package com.devcolibri.database;

import java.sql.*;

public class Main {
    private static final String URL = "jbdc:mysql://localhost:3306/mydbtest1";
    private static final String USER = "root";
    private static final String PASS = "Ehecce1002!";

    public static void main(String[] args) {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = conn.createStatement();
            System.out.println("Connected to database");

            conn.close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            System.out.println("Connection failed");
        }
    }
}
