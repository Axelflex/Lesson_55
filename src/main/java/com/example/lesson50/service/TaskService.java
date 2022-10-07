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

    public List<TaskDto> getTasks(){
        return taskDao.getAllTasks().stream()
                .map(event -> TaskDto.builder()
                        .id(event.getId())
                        .do_date_time(event.getDo_date_time())
                        .header(event.getHeader())
                        .state(event.getState())
                        .build())
                .collect(Collectors.toList());
    }
}
