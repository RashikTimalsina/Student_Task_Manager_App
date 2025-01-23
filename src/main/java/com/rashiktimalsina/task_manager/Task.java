package com.rashiktimalsina.task_manager;

public class Task {

    private int id;
    private String taskName;
    private int priority;

    public Task(int id, String taskName, int priority) {
        this.id = id;
        this.taskName = taskName;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Task{id=" + id + ", taskName='" + taskName + "', priority=" + priority + "}";
    }
}
