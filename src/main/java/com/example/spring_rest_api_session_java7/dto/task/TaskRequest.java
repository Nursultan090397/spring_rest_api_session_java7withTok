package com.example.spring_rest_api_session_java7.dto.task;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TaskRequest {
    private String taskName;
    private String taskText;
    private LocalDate deadline;
}
