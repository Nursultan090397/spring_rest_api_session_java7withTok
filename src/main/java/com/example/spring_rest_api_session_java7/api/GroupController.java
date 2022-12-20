package com.example.spring_rest_api_session_java7.api;

import com.example.spring_rest_api_session_java7.dto.group.GroupRequest;
import com.example.spring_rest_api_session_java7.dto.group.GroupResponse;
import com.example.spring_rest_api_session_java7.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;
    @GetMapping("/getAll/{id}")
    @PreAuthorize("hasAuthority('Admin')")
    public List<GroupResponse> getAllCourse(@PathVariable Long id){
        return groupService.getAlGroups(id);
    }

    @PostMapping("/save/{id}")
    public GroupResponse saveGroup(@PathVariable Long id, @RequestBody GroupRequest groupRequest)  {
        return groupService.addGroup(id, groupRequest);
    }

    @GetMapping("/findById/{id}")
    @PreAuthorize("hasAuthority('Admin')")

    public GroupResponse findById(@PathVariable Long id){
        return groupService.getGroupById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public GroupResponse deleteById(@PathVariable Long id){
        return groupService.deleteGroup(id);
    }

    @PutMapping("/update/{id}")
    public GroupResponse updateCourse(@RequestBody GroupRequest groupRequest, @PathVariable Long id)  {
        return groupService.updateGroup(id, groupRequest);
    }
}
