package com.rashiktimalsina.task_manager;

import java.util.List;

public class TaskService {

    // Add a new task
    public boolean addTask(String taskName, int priority) {
        return TaskCRUD.addTask(taskName, priority);
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        return TaskCRUD.getAllTasks();
    }

    // Delete a task
    public boolean deleteTask(int taskId) {
        return TaskCRUD.deleteTask(taskId);
    }

    // Update a task
    public boolean updateTask(int taskId, String taskName, int priority) {
        return TaskCRUD.updateTask(taskId, taskName, priority);
    }
}
