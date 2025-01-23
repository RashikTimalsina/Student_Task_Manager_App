package com.rashiktimalsina.task_manager;

import com.rashiktimalsina.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskCRUD {

    // Method to add a task
    public static boolean addTask(String taskName, int priority) {
        String query = "INSERT INTO tasks (task_name, priority) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, taskName);
            statement.setInt(2, priority);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error adding task: " + e.getMessage());
        }
        return false;
    }

    // Method to get all tasks
    public static List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        String query = "SELECT * FROM tasks";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String taskName = resultSet.getString("task_name");
                int priority = resultSet.getInt("priority");
                tasks.add(new Task(id, taskName, priority));
            }

        } catch (SQLException e) {
            System.err.println("Error fetching tasks: " + e.getMessage());
        }
        return tasks;
    }

    // Method to delete a task
    public static boolean deleteTask(int taskId) {
        String query = "DELETE FROM tasks WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, taskId);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error deleting task: " + e.getMessage());
        }
        return false;
    }

    // Method to update a task
    public static boolean updateTask(int taskId, String taskName, int priority) {
        String query = "UPDATE tasks SET task_name = ?, priority = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, taskName);
            statement.setInt(2, priority);
            statement.setInt(3, taskId);
            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error updating task: " + e.getMessage());
        }
        return false;
    }
}
