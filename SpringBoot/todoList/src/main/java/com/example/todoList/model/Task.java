package com.example.todoList.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {

    private String id, title;

    public Task(@JsonProperty("id") String id, @JsonProperty("title") String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

}
