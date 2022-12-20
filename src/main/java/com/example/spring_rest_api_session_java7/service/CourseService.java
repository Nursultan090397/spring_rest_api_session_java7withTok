package com.example.spring_rest_api_session_java7.service;


import com.example.spring_rest_api_session_java7.dto.course.CourseRequest;
import com.example.spring_rest_api_session_java7.dto.course.CourseResponse;

import java.util.List;

public interface CourseService {
    List<CourseResponse> getAllCourses(Long id);

    CourseResponse addCourse(Long id, CourseRequest courseRequest);

    CourseResponse getCourseById(Long id);

    CourseResponse updateCourse(Long courseId, CourseRequest courseRequest);

    CourseResponse deleteCourse(Long id);
}
