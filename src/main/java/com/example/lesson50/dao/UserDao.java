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

    public void save (String email, String username, String password) {
        String sql = "insert into users (email, username, password, enabled) " +
                "values (?, ?, ?, true);";
        jdbcTemplate.update(sql, email, username, password);
    }
}
