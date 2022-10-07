package com.example.lesson50.controller;

import com.example.lesson50.dao.TaskDao;
import com.example.lesson50.dto.TaskDto;
import com.example.lesson50.model.Task;
import com.example.lesson50.model.User;
import com.example.lesson50.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final TaskDao taskDao;
    @GetMapping("/getTasks")
    public ResponseEntity<List<TaskDto>> getAllTasks(){
        return new ResponseEntity<>(taskService.getTasks(), HttpStatus.OK);
    }
    @PostMapping("/createTask")
    public ResponseEntity<?> crateTask(@RequestParam String header,
                                       @RequestParam String description,
                                       @RequestParam String DoDateTime,
                                       @RequestParam Long id){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(DoDateTime, formatter);
        return new ResponseEntity<>(taskDao.createTask(header, description, dateTime, id), HttpStatus.OK);
    }
    @PostMapping("/changeState")
    public ResponseEntity<?> changeState(@RequestParam String state, Long id){
        return new ResponseEntity<>(taskDao.changeState(state, id), HttpStatus.OK);
    }
    @GetMapping("/getDetails")
    private ResponseEntity<Optional<Task>> getDetails(@RequestParam Long id){
        return new ResponseEntity<>(taskDao.getDetails(id), HttpStatus.OK);
    }
}
