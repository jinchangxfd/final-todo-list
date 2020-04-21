package com.example.todolist_demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.todolist_demo.dao.impl.TaskDaoImpl;
import com.example.todolist_demo.domain.Task;
import com.example.todolist_demo.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@SpringBootTest
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService service;

    private List<Task> tasks = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Task task = new Task();
        task.setId(1);
        task.setContent("Restful API homework");
        task.setCreatedTime("2019-05-15T00:00:00Z");
        tasks.add(task);
    }

    /**
     * 测试获取全部
     * @throws Exception
     */
    @Test
    public void shouldGetTasks() throws Exception {
        when(service.getTasks()).thenReturn(tasks);
        this.mockMvc.perform(get("/tasks"))
                .andDo(print())
                .andExpect(status()
                        .isOk())
                .andExpect(jsonPath("$[0].content")
                        .value("Restful API homework"));
    }

    /**
     * 测试按照ID获取
     * @throws Exception
     */
    @Test
    public void shouldGetTaskById() throws Exception {
        when(service.getTask(1)).thenReturn(tasks.get(0));
        this.mockMvc.perform(get("/tasks/1"))
                .andDo(print())
                .andExpect(status()
                        .isOk())
                .andExpect(jsonPath("$.content")
                        .value("Restful API homework"));
    }

    /**
     * 测试删除
     * @throws Exception
     */
    @Test
    public void shouldDeleteTask() throws Exception {
        when(service.deleteTask(1)).thenReturn(true);
        this.mockMvc.perform(delete("/tasks/2"))
                .andDo(print())
                .andExpect(status()
                        .isOk());
    }

    /**
     * 测试增加
     * @throws Exception
     */
    @Test
    public void shouldAddTask() throws Exception {
        Task task = new Task();
        task.setId(2);
        task.setContent("Restful API homework2");
        task.setCreatedTime("2020-05-15T00:00:00Z");
        when(service.addTask(task)).thenReturn(true);
        this.mockMvc.perform(post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(Arrays.asList(task))))
                .andDo(print())
                .andExpect(status()
                        .is4xxClientError());
    }

    @Test
    public void shouldUpdateTask() throws Exception {
        Task task = new Task();
        task.setId(1);
        task.setContent("Restful API homework2");
        task.setCreatedTime("2020-05-15T00:00:00Z");
        when(service.updateTask(1,task)).thenReturn(true);
        this.mockMvc.perform(put("/tasks/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(Arrays.asList(task))))
                .andDo(print())
                .andExpect(status()
                        .is4xxClientError());
    }

}
