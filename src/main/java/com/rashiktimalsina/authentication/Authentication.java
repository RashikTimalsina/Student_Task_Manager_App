package com.rashiktimalsina.authentication;

import com.rashiktimalsina.utils.DatabaseConnection;

import java.sql.*;

public class Authentication {

    // Method to authenticate user
    public static boolean authenticateUser(String username, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean isAuthenticated = false;

        try {
            connection = DatabaseConnection.getConnection();
            // SQL query to check if the username and password match
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                isAuthenticated = true; // User found
            }

        } catch (SQLException e) {
            System.err.println("Error during authentication: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
                e.printStackTrace();
            }
        }

        return isAuthenticated;
    }
}
