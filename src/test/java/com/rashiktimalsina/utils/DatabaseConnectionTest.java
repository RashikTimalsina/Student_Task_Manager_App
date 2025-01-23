package com.rashiktimalsina.utils;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DatabaseConnectionTest {

    @Test
    public void testConnection() {
        try {
            // Attempt to get a connection to the database
            Connection connection = DatabaseConnection.getConnection();

            // Assert that the connection is not null (i.e., connection was successful)
            assertNotNull(connection, "Connection should not be null");

            System.out.println("Database connection successful!");

            // Closing the connection
            DatabaseConnection.closeConnection();

        } catch (SQLException e) {
            // If an exception is thrown, print it for debugging
            System.out.println("Error occurred while testing the database connection: " + e.getMessage());
        }
    }
}
