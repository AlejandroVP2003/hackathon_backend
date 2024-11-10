package com.hackathon.backend_hackathon.application.dtos;

public class UserGroupDto {

    // Attributes
    private String name;
    private String lastName1;
    private String lastName2;
    
    // Constructors
    public UserGroupDto() {}

    public UserGroupDto(String name, String lastName1, String lastName2) {
        this.name = name;
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName1() {
        return lastName1;
    }
    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }
    public String getLastName2() {
        return lastName2;
    }
    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

}
