package com.example.spring_rest_api_session_java7.service;


import com.example.spring_rest_api_session_java7.dto.task.TaskRequest;
import com.example.spring_rest_api_session_java7.dto.task.TaskResponse;

import java.util.List;

public interface TaskService {
    List<TaskResponse> getAlTasks(Long lessonId);

    TaskResponse addTask(Long id, TaskRequest taskrequest);

    TaskResponse getTaskById(Long id);

    TaskResponse updateTask(TaskRequest taskRequest, Long id);

    TaskResponse deleteTask(Long id);
}