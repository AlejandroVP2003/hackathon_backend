package com.hackathon.backend_hackathon.domain.models;

import java.util.ArrayList;
import java.util.List;

public class Group {

    // Attributes
    private int id;
    private String name;
    private String description;
    private String code;
    private User owner;
    private List<User> members;
    
    // Constructors
    public Group() {}

    public Group(int id, String name, String description, String code, User owner, List<User> members) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.code = code;
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
    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }
    public List<User> getMembers() {
        return members == null ? new ArrayList<>() : members;
    }
    public void setMembers(List<User> members) {
        this.members = members;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    
}
