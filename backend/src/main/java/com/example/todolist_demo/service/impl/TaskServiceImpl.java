package com.example.todolist_demo.service.impl;

import com.example.todolist_demo.dao.TaskDao;
import com.example.todolist_demo.domain.Task;
import com.example.todolist_demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    TaskDao taskDao;

    @Autowired
    public TaskServiceImpl(TaskDao taskDao){
        this.taskDao = taskDao;
    }

    @Override
    public boolean addTask(Task task) {
        return this.taskDao.addTask(task);
    }

    @Override
    public boolean deleteTask(int id) {
        return this.taskDao.deleteTask(id);
    }

    @Override
    public Task getTask(int id) {
        return this.taskDao.getTask(id);
    }

    @Override
    public List<Task> getTasks() {
        return this.taskDao.getTasks();
    }

    @Override
    public boolean updateTask(int id, Task task) {
        return taskDao.updateTask(id, task);
    }
}
