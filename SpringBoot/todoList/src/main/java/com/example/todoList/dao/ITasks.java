package com.example.todoList.dao;

import com.example.todoList.model.Task;

import java.util.List;
import java.util.UUID;

public interface ITasks {

    int addTask(UUID id, Task task);
    default int addTask(Task task){
        UUID id = UUID.randomUUID();
        return addTask(id, task);
    }

    List<Task> showTasks();
    int deleteTask(UUID id);


}
