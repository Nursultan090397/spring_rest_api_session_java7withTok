package com.example.spring_rest_api_session_java7.converter.student;


import com.example.spring_rest_api_session_java7.dto.student.StudentResponse;
import com.example.spring_rest_api_session_java7.entities.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentResponseConverter {
    public StudentResponse viewStudent(Student student) {
        if (student == null) {
            return null;
        }
        StudentResponse studentResponse = new StudentResponse();

        studentResponse.setId(student.getId());
        studentResponse.setLastName(student.getLastName());
        studentResponse.setFirstName(student.getFirstName());
        studentResponse.setEmail(student.getEmail());
        studentResponse.setStudyFormat(student.getStudyFormat());
        return studentResponse;
    }

    public List<StudentResponse> view(List<Student> students) {
        List<StudentResponse> studentResponseList = new ArrayList<>();
        for (Student student : students) {
            studentResponseList.add(viewStudent(student));
        }
        return studentResponseList;
    }
}
