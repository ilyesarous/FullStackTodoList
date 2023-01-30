package com.example.todoList.api;

import com.example.todoList.model.Task;
import com.example.todoList.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
@CrossOrigin
public class Controller {

    private final Service service;

    @Autowired
    public Controller(Service s){
        this.service = s;
    }

    @PostMapping("/add")
    int addTask(@NonNull @RequestBody Task t){
        return service.addTask(t);
    }
    @GetMapping("/getAll")
    List<Task> showTasks(){
        return service.showTasks();
    }

    @DeleteMapping(path = "{id}")
    int deleteTask(@PathVariable("id") UUID id){
        return service.deleteTask(id);
    }
}
