package com.example.lesson50.dao;

import com.example.lesson50.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TaskDao {

    private final JdbcTemplate jdbcTemplate;
    public Optional<Task> getAllTasks(){
        String sql = "select * from tasks;";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Task.class)));
    }

    public String createTask(String header, String description, LocalDateTime DoDateTime){
        String sql = "insert into tasks(header, description, DoDateTime) " +
                "values (?, ?, ?);";
        jdbcTemplate.update(sql, header, description, DoDateTime);
        return "Task have been created";
    }

    public String changeState(String state, Long id){
        String sql = "update tasks " +
                "set state " +
                "where id = ?;";
        jdbcTemplate.update(sql, state, id);
        return "State has been changed";
    }
    public Optional<Task> getDetails(Long id){
        String sql = "select * from tasks " +
                "where id = ?;";
       return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Task.class), id));
    }
}
