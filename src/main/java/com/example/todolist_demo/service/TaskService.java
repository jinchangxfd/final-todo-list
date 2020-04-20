package com.example.todolist_demo.service;

import com.example.todolist_demo.domain.Task;

public interface TaskService {
    public void addTask(Task task);
    public void deleteTask(int id);
    public Task getTask(int id);
    public Task[] getTasks();
    public void updateTask(Task task);
}
