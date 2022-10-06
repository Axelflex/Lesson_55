package com.example.lesson50.dto;

import com.example.lesson50.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Long id;
    private String header;
    private String description;
    private LocalDateTime DoDateTime;
    private User user;
    private String state;
}
