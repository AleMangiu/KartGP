package com.example.kartgp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static Connection connection;
    private static String dbUrl = "jdbc:mysql://localhost:3306/kartgp";
    private static String username = "root";
    private static String password = "1234";

    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(dbUrl, username, password);
        return connection;
    }
}
