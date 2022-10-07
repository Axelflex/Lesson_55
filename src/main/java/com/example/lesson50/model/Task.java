package com.example.lesson50.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private Long id;
    private String header;
    private String description;
    private LocalDateTime do_date_time;
    private User user_id;
    private String state;
}
