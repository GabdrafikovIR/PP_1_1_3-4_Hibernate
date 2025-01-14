package com.devcolibri;

import java.lang.ref.SoftReference;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest1";
    private static final String USER = "root";
    private static final String PASSWORD = "Ehecce1002!";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();) {
            //stmt.execute("insert into animals (anim_name, anim_desc) values ('name', 'desc')");
//            stmt.addBatch("insert into animals (anim_name, anim_desc) values ('batch1', 'desc')");
//            stmt.addBatch("insert into animals (anim_name, anim_desc) values ('batch2', 'desc')");
//            stmt.addBatch("insert into animals (anim_name, anim_desc) values ('batch3', 'desc')");
//
//            stmt.executeBatch();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}