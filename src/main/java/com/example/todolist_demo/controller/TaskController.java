package com.example.todolist_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}
