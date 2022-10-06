package com.example.lesson50.controller;

import com.example.lesson50.dao.UserDao;
import com.example.lesson50.dto.TaskDto;
import com.example.lesson50.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController("/users")
@RequiredArgsConstructor
public class UserController {
    private final TaskService taskService;
    private final UserDao userDao;

    @GetMapping("/getTasks")
    private ResponseEntity<List<TaskDto>> getAllTasks(){
        return new ResponseEntity<>(taskService.getTasks(), HttpStatus.OK);
    }
    @PostMapping("/createTask")
    private ResponseEntity<?> crateTask(@RequestParam String header,
                                        @RequestParam String description,
                                        @RequestParam LocalDateTime DoDateTime){
        return new ResponseEntity<>(userDao.createTask(header, description, DoDateTime), HttpStatus.OK);
    }
}
