package com.example.lesson50.service;

import com.example.lesson50.dao.TaskDao;
import com.example.lesson50.dao.UserDao;
import com.example.lesson50.dto.TaskDto;
import com.example.lesson50.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskDao taskDao;

    private final UserDao userDao;

    public List<TaskDto> getTasks(){
        return userDao.getAllTasks().stream()
                .map(event -> TaskDto.builder()
                        .id(event.getId())
                        .DoDateTime(event.getDoDateTime())
                        .header(event.getHeader())
                        .state(event.getState())
                        .build())
                .collect(Collectors.toList());
    }
}
