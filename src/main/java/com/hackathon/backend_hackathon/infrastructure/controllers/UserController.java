package com.hackathon.backend_hackathon.infrastructure.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.backend_hackathon.application.dtos.GroupDto;
import com.hackathon.backend_hackathon.application.dtos.UserDto;
import com.hackathon.backend_hackathon.application.services.UserService;
import com.hackathon.backend_hackathon.domain.models.User;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int id) {
        return userService.getUserById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    @GetMapping("/{id}/groups")
    public ResponseEntity<List<GroupDto>> getGroupsPerUser(@PathVariable int id) {
        List<GroupDto> groupDtos = userService.getGroupsPerUser(id);
        return ResponseEntity.ok(groupDtos);
    }

    @PostMapping("/{id}/joinGroup/{groupId}")
    public ResponseEntity<String> joinGroup(@PathVariable int id, @PathVariable int groupId) {
        try {
            userService.joinGroup(id, groupId);
            return ResponseEntity.ok("User joined group successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to join group: " + e.getMessage());
        }
    }
    
}
