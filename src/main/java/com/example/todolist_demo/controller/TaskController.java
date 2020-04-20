package com.example.todolist_demo.controller;

import com.example.todolist_demo.domain.Task;
import com.example.todolist_demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }
    @ResponseBody
    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    public Task getTask(@PathVariable("id") int id){
        return this.taskService.getTask(id);
    }
    @ResponseBody
    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    public boolean addTask(@RequestBody Task task){
        return this.taskService.addTask(task);
    }

    @ResponseBody
    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    public boolean deleteTask(@PathVariable("id") int id){
        return this.taskService.deleteTask(id);
    }

    @ResponseBody
    @RequestMapping(value = "tasks", method = RequestMethod.GET)
    public List<Task> getTasks(){
        return this.taskService.getTasks();
    }

    @ResponseBody
    @RequestMapping(value = "tasks/{id}", method = RequestMethod.PUT)
    public boolean updateTask(@PathVariable("id") int id, @RequestBody Task task){
        return this.taskService.updateTask(id, task);
    }


}
