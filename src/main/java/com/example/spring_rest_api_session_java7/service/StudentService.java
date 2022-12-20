package com.example.spring_rest_api_session_java7.service;




import com.example.spring_rest_api_session_java7.dto.student.StudentRequest;
import com.example.spring_rest_api_session_java7.dto.student.StudentResponse;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    List<StudentResponse> getStudentList();

    List<StudentResponse> getAlStudents(Long groupId);

    StudentResponse addStudent(Long id, StudentRequest studentRequest) throws IOException;

    StudentResponse getStudentById(Long id);

    StudentResponse updateStudent(StudentRequest studentRequest, Long id);

    StudentResponse deleteStudent(Long id);

    void assignStudent(Long groupId,Long studentId) throws IOException;
}
