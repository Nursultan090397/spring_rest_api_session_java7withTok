package com.example.spring_rest_api_session_java7.service;





import com.example.spring_rest_api_session_java7.dto.instructor.InstructorRequest;
import com.example.spring_rest_api_session_java7.dto.instructor.InstructorResponse;

import java.io.IOException;
import java.util.List;

public interface InstructorService {
    List<InstructorResponse> getInstructorList();
    List<InstructorResponse> getAlInstructors(Long courseId);

    InstructorResponse addInstructor(Long id, InstructorRequest instructorRequest);

    InstructorResponse getInstructorById(Long id);

    InstructorResponse updateInstructor(Long id, InstructorRequest instructorRequest);

    InstructorResponse deleteInstructor(Long id);

    void assignInstructor(Long courseId,Long instructorId) throws IOException;
}
