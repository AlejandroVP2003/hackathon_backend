package com.hackathon.backend_hackathon.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.backend_hackathon.application.dtos.GroupDto;
import com.hackathon.backend_hackathon.application.dtos.create.GroupCreateDto;
import com.hackathon.backend_hackathon.application.services.GroupService;


@RestController
@RequestMapping("/api/groups")
public class GroupController {
    
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupDto> getGroupById(@PathVariable int id) {
        return groupService.getGroupById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createGroup(@RequestBody GroupCreateDto groupCreateDto) {
        groupService.createGroup(groupCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Group created successfully");
    }

    @PostMapping("/{id}/addUser/{userId}")
    public ResponseEntity<String> addUserToGroup(@PathVariable int id, @PathVariable int userId) {
        try {
            groupService.addUserToGroup(id, userId);
            return ResponseEntity.ok("User added to group successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add user to group: " + e.getMessage());
        }
    }

}
