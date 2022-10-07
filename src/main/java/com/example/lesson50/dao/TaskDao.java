package com.example.lesson50.dao;

import com.example.lesson50.model.Task;
import com.example.lesson50.model.User;
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
        String sql = "select id, header, do_date_time, state from tasks;";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Task.class)));
    }

    public String createTask(String header, String description, LocalDateTime do_date_time, Long user_id){
        String sql = "insert into tasks(header, description, do_date_time, user_id) " +
                "values (?, ?, ?, ?);";
        jdbcTemplate.update(sql, header, description, do_date_time, user_id);
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
