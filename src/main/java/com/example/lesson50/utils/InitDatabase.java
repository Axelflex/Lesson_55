package com.example.lesson50.utils;

import com.example.lesson50.dao.*;
import com.example.lesson50.model.User;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@AllArgsConstructor
@Configuration
public class InitDatabase {

    private final PasswordEncoder encoder;


    @Bean
    public CommandLineRunner fillData() {
        return (args) -> {


        };
    }
}
