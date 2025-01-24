package com.rashiktimalsina.utils;

import com.rashiktimalsina.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection = null;

    private DatabaseConnection() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                // Load MySQL JDBC Driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Retrieve credentials from DatabaseConfig
                String url = DatabaseConfig.getUrl();
                String user = DatabaseConfig.getUser();
                String password = DatabaseConfig.getPassword();

                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Database connected successfully!");
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println("Error connecting to the database: " + e.getMessage());
                throw new SQLException("Database connection failed.", e);
            }
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error closing the database connection: " + e.getMessage());
        }
    }
}
