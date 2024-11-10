package com.hackathon.backend_hackathon.application.dtos;

import java.util.List;

public class GroupDto {
    
    // Attributes
    private int id;
    private String name;
    private String description;
    private String code;
    private UserGroupDto owner;
    private List<UserGroupDto> members;
    
    // Constructors
    public GroupDto() {}

    public GroupDto(int id, String name, String description, String code, UserGroupDto owner, List<UserGroupDto> members) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.code = code;
        this.owner = owner;
        this.members = members;
    }
    
    // Getters & Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public UserGroupDto getOwner() {
        return owner;
    }
    public void setOwner(UserGroupDto owner) {
        this.owner = owner;
    }
    public List<UserGroupDto> getMembers() {
        return members;
    }
    public void setMembers(List<UserGroupDto> members) {
        this.members = members;
    }

}
