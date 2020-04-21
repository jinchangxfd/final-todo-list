package com.example.todolist_demo.service;

import com.example.todolist_demo.dao.impl.TaskDaoImpl;
import com.example.todolist_demo.domain.Task;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskServiceTest {

    @Autowired
    private TaskDaoImpl taskDao;

    @Autowired
    private TaskService taskService;

    @AfterEach
    void tearDown() {
        Task task = new Task();
        task.setId(1);
        task.setContent("Restful API homework");
        task.setCreatedTime("2019-05-15T00:00:00Z");
        taskDao.writeData(Arrays.asList(task));
    }

    @Test
    public void shouldGetTasks() {
        List<Task> tasks = taskService.getTasks();
        assertEquals(1, tasks.size());
        assertEquals(1L, tasks.get(0).getId());
        assertEquals("Restful API homework", tasks.get(0).getContent());
        assertEquals("2019-05-15T00:00:00Z", tasks.get(0).getCreatedTime());
    }

    @Test
    public void shouldGetTaskById() {
        Task task = taskService.getTask(1);
        assertEquals("Restful API homework", task.getContent());
        assertEquals("2019-05-15T00:00:00Z", task.getCreatedTime());
    }

    @Test
    public void shouldAddTask() {
        Task task = new Task();
        task.setId(2);
        task.setContent("Restful API homework2");
        task.setCreatedTime("2020-05-15T00:00:00Z");
        taskService.addTask(task);
        Task task1 = taskService.getTask(2);
        assertEquals("Restful API homework2", task1.getContent());
        assertEquals("2020-05-15T00:00:00Z", task1.getCreatedTime());
    }

    @Test
    public void shouldUpdateTask() {
        Task task = taskService.getTask(1);
        task.setContent("Restful API homework2");
        task.setCreatedTime("2020-05-15T00:00:00Z");
        taskService.updateTask(1,task);
        Task task1 = taskService.getTask(1);
        assertEquals("Restful API homework2", task1.getContent());
        assertEquals("2020-05-15T00:00:00Z", task1.getCreatedTime());
    }

    @Test
    public void shouldDeleteTask() {
        taskService.deleteTask(1);
        List<Task> tasks = taskService.getTasks();
        assertEquals(0,tasks.size());
    }
}
