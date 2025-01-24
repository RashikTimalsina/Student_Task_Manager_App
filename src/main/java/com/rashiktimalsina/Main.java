package com.rashiktimalsina;

import com.rashiktimalsina.authentication.UserLogin;
import com.rashiktimalsina.authentication.UserRegistration;
import com.rashiktimalsina.task_manager.TaskManager;
import com.rashiktimalsina.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final String MAIN_MENU_TITLE = "\n--- Welcome to the Student Task Manager App ---";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Establish a database connection when the app starts
        try {
            Connection connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
            return;
        }

        while (true) {
            System.out.println(MAIN_MENU_TITLE);
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear the newline character

                switch (choice) {
                    case 1:
                        // Login existing user
                        if (UserLogin.loginUser()) {
                            TaskManager.taskManagementMenu(); // Show task management menu if login is successful
                        }
                        break;

                    case 2:
                        // Register a new user
                        UserRegistration.registerUser();
                        break;

                    case 3:
                        // Exit the application with confirmation
                        System.out.print("Are you sure you want to exit? (y/n): ");
                        String confirm = scanner.nextLine();
                        if (confirm.equalsIgnoreCase("y")) {
                            System.out.println("Exiting the application...");
                            scanner.close();
                            return;
                        } else {
                            System.out.println("Returning to the main menu.");
                        }
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}
