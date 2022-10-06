package com.example.lesson50.dao;

import com.example.lesson50.model.Task;
import com.example.lesson50.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public void deleteAll() {
        String query = "delete from users";
        jdbcTemplate.update(query);
    }

    public void save (User user) {
        String sql = "insert into users (email, username, password, enabled) " +
                "values (?, ?, ?, true);";
        jdbcTemplate.update(sql, user.getEmail(), user.getUsername(), user.getPassword());
    }
    public Optional<Task> getAllTasks(){
        String sql = "selec * from tasks;";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Task.class)));
    }

    public String createTask(String header, String description, LocalDateTime DoDateTime){
        String sql = "insert into tasks(header, description, DoDateTime) " +
                "values (?, ?, ?);";
        jdbcTemplate.update(sql, header, description, DoDateTime);
        return "Task have been created";
    }
}
