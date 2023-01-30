package com.example.todoList.dao;

import com.example.todoList.model.Task;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("tasks")
public class TaskImpl implements ITasks{

    List<Task> tasks = new ArrayList<Task>();
    private final JdbcTemplate jdbcTemplate;

    public TaskImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addTask(UUID id, Task task) {
        jdbcTemplate.execute("insert into tasks(id,title) values(" +
                "'"+id.toString()+"', " +
                "'"+task.getTitle()+"');");
        return 1;
    }

    @Override
    public List<Task> showTasks() {
        return jdbcTemplate.query("select * from tasks", (rs, rowNum) -> new Task(
                rs.getString("id"),
                rs.getString("title")));
    }

    @Override
    public int deleteTask(UUID id) {
        jdbcTemplate.execute("delete from tasks where id = '"+id.toString()+"'");
        return 1;
    }
}
