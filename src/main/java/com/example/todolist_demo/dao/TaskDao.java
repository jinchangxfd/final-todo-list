package com.example.todolist_demo.dao;

import com.example.todolist_demo.domain.Task;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.List;

public interface TaskDao {
    public boolean addTask(Task task);
    public boolean deleteTask(int id);
    public Task getTask(int id);
    public List<Task> getTasks();
    public boolean updateTask(int id, Task task);
}
