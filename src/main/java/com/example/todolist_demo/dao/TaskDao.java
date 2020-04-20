package com.example.todolist_demo.dao;

import com.example.todolist_demo.domain.Task;

public interface TaskDao {
    public void addTask(Task task);
    public void deleteTask(int id);
    public Task getTask(int id);
    public Task[] getTasks();
    public void updateTask(Task task);
}
