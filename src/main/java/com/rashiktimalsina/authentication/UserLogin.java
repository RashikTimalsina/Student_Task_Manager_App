package com.rashiktimalsina.authentication;

import java.util.Scanner;

public class UserLogin {

    // Method to authenticate user login
    public static boolean loginUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Assuming authenticateUser method in Authentication class
        boolean isAuthenticated = Authentication.authenticateUser(username, password);

        if (isAuthenticated) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }
}
