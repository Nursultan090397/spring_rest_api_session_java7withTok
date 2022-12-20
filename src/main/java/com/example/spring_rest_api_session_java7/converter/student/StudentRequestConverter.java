package com.example.spring_rest_api_session_java7.converter.student;


import com.example.spring_rest_api_session_java7.dto.student.StudentRequest;
import com.example.spring_rest_api_session_java7.entities.Student;
import org.springframework.stereotype.Component;


@Component
public class StudentRequestConverter {
    public Student createStudent(StudentRequest studentRequest) {
        if (studentRequest == null) {
            return null;
        }
        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setEmail(studentRequest.getEmail());
        student.setStudyFormat(studentRequest.getStudyFormat());
        return student;
    }

    public void updateStudent(StudentRequest studentRequest,Student student) {
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setEmail(studentRequest.getEmail());
        student.setStudyFormat(studentRequest.getStudyFormat());
    }
}
