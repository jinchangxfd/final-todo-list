package com.example.todolist_demo.dao.impl;

import com.example.todolist_demo.domain.Task;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskDaoImplTest {

    TaskDaoImpl taskDao = new TaskDaoImpl();
    @BeforeClass
    public static void beforeClass() {
        System.out.println("in before class");
    }
    @Test
    void addTask() {
        Task task = new Task();
        task.setId(1);
        task.setCreatedTime("2000");
        task.setContent("hello");
    }

    @Test
    void deleteTask() {
    }

    @Test
    void getTask() {
        Task task = taskDao.getTask(1);
        System.out.println("kkk");
    }

    @Test
    void getTasks() {
    }

    @Test
    void updateTask() {
    }
}