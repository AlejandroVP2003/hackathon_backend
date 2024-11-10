package com.hackathon.backend_hackathon.application.dtos;

import java.util.Date;
import java.util.List;

public class EventDto {

    // Attributes
    private int id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private int type;
    private List<UserGroupDto> users;
    
    // Constructors
    public EventDto() {}

    public EventDto(int id, String name, String description, Date startDate, Date endDate, int type, List<UserGroupDto> users) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.users = users;
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
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public List<UserGroupDto> getUsers() {
        return users;
    }
    public void setUsers(List<UserGroupDto> users) {
        this.users = users;
    }

}
