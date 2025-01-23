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

                    if (UserLogin.loginUser()) {        //this will prompt login for existing students
                        TaskManager.taskManagementMenu();       //show task-management-menu
                    }
                    break;

                case 2:
                    UserRegistration.registerUser();      //this will prompt registration for new students
                    break;

                case 3:
                    System.out.println("Exiting the application...");       //exit the program
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
