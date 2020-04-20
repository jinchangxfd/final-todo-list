package com.example.todolist_demo.service;

import com.example.todolist_demo.domain.Task;

import java.util.List;

public interface TaskService {
    public boolean addTask(Task task);
    public boolean deleteTask(int id);
    public Task getTask(int id);
    public List<Task> getTasks();
    public boolean updateTask(int id, Task task);
}
