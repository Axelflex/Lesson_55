package com.example.lesson50.controller;

import com.example.lesson50.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserDao userDao;

    @PostMapping("/createUser")
    public void createUser(@RequestParam String email,
                           @RequestParam String username,
                           @RequestParam String password){
        userDao.save(email, username, password);
    }
}
