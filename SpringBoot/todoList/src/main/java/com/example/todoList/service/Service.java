package com.example.todoList.service;

import com.example.todoList.dao.ITasks;
import com.example.todoList.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.UUID;

@org.springframework.stereotype.Service
public class Service {

    private final ITasks tasks;

    @Autowired
    public Service(@Qualifier("tasks") ITasks tasks) {
        this.tasks = tasks;
    }

    public int addTask(Task t){
        return tasks.addTask(t);
    }
    public List<Task> showTasks(){
        return tasks.showTasks();
    }

    public int deleteTask(UUID t){
        return tasks.deleteTask(t);
    }
}
