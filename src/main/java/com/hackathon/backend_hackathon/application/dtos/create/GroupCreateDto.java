package com.hackathon.backend_hackathon.application.dtos.create;

import java.util.ArrayList;
import java.util.List;

public class GroupCreateDto {
    
    // Attributes
    private int id;
    private String name;
    private String description;
    private int owner;
    private List<Integer> members;
    
    // Constructors
    public GroupCreateDto() {}

    public GroupCreateDto(int id, String name, String description, int owner, List<Integer> members) {
        this.id = id;
        this.name = name;
        this.description = description;
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
    public int getOwner() {
        return owner;
    }
    public void setOwner(int owner) {
        this.owner = owner;
    }
    public List<Integer> getMembers() {
        return members == null ? new ArrayList<>() : members;
    }
    public void setMembers(List<Integer> members) {
        this.members = members;
    }

}
