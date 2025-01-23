package com.rashiktimalsina.task_manager;

import java.util.List;
import java.util.Scanner;

public class TaskManager {

    private static TaskService taskService = new TaskService();

    public static void taskManagementMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Task Management Menu ---");
            System.out.println("1. View Tasks");
            System.out.println("2. Add Task");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // View all tasks
                    viewTasks();
                    break;

                case 2:
                    // Add a new task
                    addTask(scanner);
                    break;

                case 3:
                    // Update an existing task
                    updateTask(scanner);
                    break;

                case 4:
                    // Delete a task
                    deleteTask(scanner);
                    break;

                case 5:
                    // Exit task management
                    System.out.println("Exiting task management...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewTasks() {
        List<Task> tasks = taskService.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\n--- Task List ---");
            for (Task task : tasks) {
                System.out.println("ID: " + task.getId() + ", Name: " + task.getTaskName() + ", Priority: " + task.getPriority());
            }
        }
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter task name: ");
        String taskName = scanner.nextLine();

        System.out.print("Enter task priority (1-5): ");
        int priority = scanner.nextInt();

        boolean isAdded = taskService.addTask(taskName, priority);
        if (isAdded) {
            System.out.println("Task added successfully.");
        } else {
            System.out.println("Failed to add task.");
        }
    }

    private static void updateTask(Scanner scanner) {
        System.out.print("Enter task ID to update: ");
        int taskId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter new task name: ");
        String newTaskName = scanner.nextLine();

        System.out.print("Enter new task priority (1-5): ");
        int newPriority = scanner.nextInt();

        boolean isUpdated = taskService.updateTask(taskId, newTaskName, newPriority);
        if (isUpdated) {
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Failed to update task.");
        }
    }

    private static void deleteTask(Scanner scanner) {
        System.out.print("Enter task ID to delete: ");
        int taskId = scanner.nextInt();

        boolean isDeleted = taskService.deleteTask(taskId);
        if (isDeleted) {
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Failed to delete task.");
        }
    }
}
