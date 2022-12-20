package com.example.spring_rest_api_session_java7.dto.student;


import com.example.spring_rest_api_session_java7.entities.StudyFormat;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private StudyFormat studyFormat;
}
