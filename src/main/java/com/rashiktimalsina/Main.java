package com.rashiktimalsina;

import com.rashiktimalsina.authentication.UserLogin;
import com.rashiktimalsina.authentication.UserRegistration;
import com.rashiktimalsina.task_manager.TaskManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Welcome to the Student Task Manager App ---");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Proceed to user login
                    if (UserLogin.loginUser()) {
                        // After successful login, show task management menu
                        TaskManager.taskManagementMenu();
                    }
                    break;

                case 2:
                    // Proceed to user registration
                    UserRegistration.registerUser();
                    break;

                case 3:
                    // Exit the program and return control to terminal
                    System.out.println("Exiting the application...");
                    scanner.close();  // Close the scanner resource
                    return;  // This will exit the main method and return control to the terminal

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
