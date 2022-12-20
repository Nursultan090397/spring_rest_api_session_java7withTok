package com.example.spring_rest_api_session_java7.converter.task;


import com.example.spring_rest_api_session_java7.dto.task.TaskRequest;
import com.example.spring_rest_api_session_java7.entities.Task;
import org.springframework.stereotype.Component;


@Component
public class TaskRequestConverter {
    public Task createTask(TaskRequest taskRequest) {
        if (taskRequest == null) {
            return null;
        }
        Task  task = new Task ();
        task.setTaskName(taskRequest.getTaskName());
        task.setTaskText(taskRequest.getTaskText());
        task.setDeadline(taskRequest.getDeadline());


        return task;
    }

    public void updateTask(TaskRequest taskRequest,Task task) {
        task.setTaskName(taskRequest.getTaskName());
        task.setTaskText(taskRequest.getTaskText());
        task.setDeadline(taskRequest.getDeadline());
    }
}