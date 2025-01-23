package com.rashiktimalsina.task_manager;

import java.util.List;

public class TaskService {

    // Adds a new task
    public boolean addTask(String taskName, int priority) {
        return TaskCRUD.addTask(taskName, priority);
    }

    // Reads/Views the tasks
    public List<Task> getAllTasks() {
        return TaskCRUD.getAllTasks();
    }

    // Deletes a task
    public boolean deleteTask(int taskId) {
        return TaskCRUD.deleteTask(taskId);
    }

    // Updates a task
    public boolean updateTask(int taskId, String taskName, int priority) {
        return TaskCRUD.updateTask(taskId, taskName, priority);
    }
}
