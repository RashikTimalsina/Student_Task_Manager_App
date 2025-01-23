package com.rashiktimalsina.authentication;

import com.rashiktimalsina.utils.DatabaseConnection;

import java.sql.*;
import java.util.Scanner;

public class UserRegistration {

    public static void registerUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Student Task Manager App!");
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO users (username, password) VALUES (?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password); // Save plain text password
            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("User registered successfully!");
            } else {
                System.out.println("Failed to register user.");
            }

        } catch (SQLException e) {
            System.err.println("Error during registration: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
