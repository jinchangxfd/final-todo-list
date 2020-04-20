package com.example.todolist_demo.dao.impl;

import com.example.todolist_demo.dao.TaskDao;
import com.example.todolist_demo.domain.Task;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Repository
public class TaskDaoImpl implements TaskDao {

    String filePath = Objects.requireNonNull(this.getClass().getClassLoader().getResource("./data/data.json")).getPath();
    File jsonFile = new File(filePath);
    ObjectMapper mapper = new ObjectMapper();

    public static JavaType getCollectionType(ObjectMapper mapper,
                                             Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().
                constructParametricType(collectionClass, elementClasses);
    }

    public List<Task> readData(){
        List<Task> taskList = null;
        try {
            taskList = this.mapper.readValue(this.jsonFile,
                    getCollectionType(this.mapper, List.class, Task.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return taskList;
    }

    public void writeData(List<Task> taskList){
        try {
            this.mapper.writeValue(this.jsonFile, taskList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean addTask(Task task) {
        boolean flag = false;
        List<Task> taskList = this.readData();
        int size = taskList.size();
//        String jsonTask = this.mapper.writeValueAsString(task);
        taskList.add(task);
        this.writeData(taskList);
        if(taskList.size() == size + 1){
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean deleteTask(int id) {
        boolean flag = false;
        List<Task> taskList = this.readData();
        flag = taskList.removeIf(task -> task.getId() == id);
        this.writeData(taskList);
        return flag;
    }

    @Override
    public Task getTask(int id) {
        List<Task> taskList = this.readData();
        Task task = null;
        for (Task t: taskList) {
            if(t.getId() == id){
                task = t;
            }
        }
        return task;
    }

    @Override
    public List<Task> getTasks() {
        return this.readData();
    }

    @Override
    public boolean updateTask(int id, Task task) {
        List<Task> taskList = this.readData();
        boolean flag = false;
        for (int i = 0; i < taskList.size(); i++) {
            if(taskList.get(i).getId() == id){
                taskList.set(i, task);
                flag = true;
            }
        }
        this.writeData(taskList);
        return flag;
    }
}
