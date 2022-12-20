package com.example.spring_rest_api_session_java7.service.impl;


import com.example.spring_rest_api_session_java7.converter.course.CourseRequestConverter;
import com.example.spring_rest_api_session_java7.converter.course.CourseResponseConverter;
import com.example.spring_rest_api_session_java7.dto.course.CourseRequest;
import com.example.spring_rest_api_session_java7.dto.course.CourseResponse;
import com.example.spring_rest_api_session_java7.entities.Company;
import com.example.spring_rest_api_session_java7.entities.Course;
import com.example.spring_rest_api_session_java7.repository.CompanyRepository;
import com.example.spring_rest_api_session_java7.repository.CourseRepository;
import com.example.spring_rest_api_session_java7.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepository;
    private final CourseResponseConverter courseResponseConverter;
    private final CourseRequestConverter courseRequestConverter;


    @Override
    public List<CourseResponse> getAllCourses(Long id) {
        return courseResponseConverter.view(courseRepository.getAllCourses(id));
    }

    @Override
    public CourseResponse addCourse(Long id, CourseRequest courseRequest) {
        Course course = courseRequestConverter.createCourse(courseRequest);
        Company company = companyRepository.getById(id);
        company.addCourse(course);
        course.setCompany(company);
        courseRepository.save(course);
        return courseResponseConverter.viewCourse(course);
    }

    @Override
    public CourseResponse getCourseById(Long id) {
        Course course = courseRepository.findById(id).get();
        return courseResponseConverter.viewCourse(course);
    }

    @Override
    public CourseResponse updateCourse(Long id, CourseRequest courseRequest)  {
        Course course = courseRepository.findById(id).get();
        courseRequestConverter.updateCourse(course, courseRequest);
        courseRepository.save(course);

        return courseResponseConverter.viewCourse(course);
    }

    @Override
    public CourseResponse deleteCourse(Long id) {
        Course course = courseRepository.findById(id).get();
        courseRepository.delete(course);
        return courseResponseConverter.viewCourse(course);
    }

    }

