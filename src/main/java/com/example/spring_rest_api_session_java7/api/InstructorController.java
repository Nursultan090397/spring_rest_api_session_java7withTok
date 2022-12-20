package com.example.spring_rest_api_session_java7.api;

import com.example.spring_rest_api_session_java7.dto.instructor.InstructorRequest;
import com.example.spring_rest_api_session_java7.dto.instructor.InstructorResponse;
import com.example.spring_rest_api_session_java7.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/instructor")
@RequiredArgsConstructor
public class InstructorController {
    private final InstructorService instructorService;

    @GetMapping("/getAll")
    @PreAuthorize("hasAuthority('Admin')")
    public List<InstructorResponse> getAllInstructor(){
        return instructorService.getInstructorList();
    }

    @GetMapping("/getAllByCourseId/{courseId}")
    @PreAuthorize("hasAuthority('Admin')")
    public List<InstructorResponse> getAllInstructor(@PathVariable Long courseId){
        return instructorService.getAlInstructors(courseId);
    }

    @PostMapping("/save/{id}")
    public InstructorResponse saveInstructor(@PathVariable Long id, @RequestBody InstructorRequest instructorRequest) throws IOException {
        return instructorService.addInstructor(id, instructorRequest);
    }

    @GetMapping("/findById/{id}")
    @PreAuthorize("hasAuthority('Admin')")
    public InstructorResponse findById(@PathVariable Long id){
        return instructorService.getInstructorById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public InstructorResponse deleteById(@PathVariable Long id){
        return instructorService.deleteInstructor(id);
    }

    @PutMapping("/update/{id}")
    public InstructorResponse updateInstructor(@RequestBody InstructorRequest instructorRequest, @PathVariable Long id) throws IOException {
        return instructorService.updateInstructor(id, instructorRequest);
    }

    @PostMapping("/assignInstructor/{instructorId}/{courseId}")
    public void assignInstructor(@PathVariable("instructorId")Long instructorId, @PathVariable("courseId") Long courseId) throws IOException {
        instructorService.assignInstructor(courseId, instructorId);
    }
}