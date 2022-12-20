package com.example.spring_rest_api_session_java7.service.impl;


import com.example.spring_rest_api_session_java7.converter.student.StudentRequestConverter;
import com.example.spring_rest_api_session_java7.converter.student.StudentResponseConverter;
import com.example.spring_rest_api_session_java7.dto.student.StudentRequest;
import com.example.spring_rest_api_session_java7.dto.student.StudentResponse;
import com.example.spring_rest_api_session_java7.entities.Course;
import com.example.spring_rest_api_session_java7.entities.Group;
import com.example.spring_rest_api_session_java7.entities.Student;
import com.example.spring_rest_api_session_java7.repository.GroupRepository;
import com.example.spring_rest_api_session_java7.repository.StudentRepository;
import com.example.spring_rest_api_session_java7.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    private final StudentRequestConverter studentRequestConverter;
    private final StudentResponseConverter studentResponseConverter;

    @Override
    public List<StudentResponse> getStudentList() {
        return studentResponseConverter.view(studentRepository.findAll());
    }

    @Override
    public List<StudentResponse> getAlStudents(Long id) {
        return studentResponseConverter.view(studentRepository.findAllStudentByGroupId(id));
    }

    @Override
    public StudentResponse addStudent(Long id, StudentRequest studentRequest) throws IOException {
        List<Student> students = studentRepository.findAll();
        for (Student i : students) {
            if (i.getEmail().equals(studentRequest.getEmail())) {
                throw new IOException("Student with email already exists!");
            }
        }
        Student student = studentRequestConverter.createStudent(studentRequest);

        Group group = groupRepository.getById( id);
        group.addStudent(student);
        student.setGroup(group);
       /* for (Course c:student.getGroup().getCourseList()) {
            for (Instructor i: c.getInstructorList()) {
                i.();*/


        studentRepository.save(student);

        return studentResponseConverter.viewStudent(student);
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        return studentResponseConverter.viewStudent(studentRepository.getById(id));
    }

    @Override
    public StudentResponse updateStudent(StudentRequest studentRequest, Long id) {
        Student student1 = studentRepository.getById(id);
       studentRequestConverter.updateStudent(studentRequest,student1);
        studentRepository.save(student1);
        return studentResponseConverter.viewStudent(student1);
    }

    @Override

    public StudentResponse deleteStudent(Long id) {
        Student student = studentRepository.getById(id);
        for (Course c:student.getGroup().getCourseList()) {
            c.getCompany().kemuuStudent();
        }
        studentRepository.delete(student);
        return studentResponseConverter.viewStudent(student);
    }

    @Override
    public void assignStudent(Long groupId, Long studentId) throws IOException {
        Student student = studentRepository.getById(studentId);
        Group group = groupRepository.getById(groupId);

        if (group.getStudentList()!=null){
            for (Student g : group.getStudentList()) {
                if (g.getId() == studentId) {
                    throw new IOException("This student already exists!");
                }
            }
        }

        student.getGroup().getStudentList().remove(student);
        group.addStudent(student);
        student.setGroup(group);
        studentRepository.save(student);
        groupRepository.save(group);
    }
}
