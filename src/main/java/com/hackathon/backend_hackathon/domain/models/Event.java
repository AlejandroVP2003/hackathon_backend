package com.hackathon.backend_hackathon.domain.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Event {
    
    // Attributes
    private int id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private int type;
    private double latitude;
    private double longitude;
    private List<User> users;
    private List<Comment> comments;
    private String key;

    // Constructors
    public Event() {}

    public Event(int id, String name, String description, Date startDate, Date endDate, int type, double latitude,
            double longitude, List<User> users, List<Comment> comments, String key) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.users = users;
        this.comments = comments;
        this.key = key;
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
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public List<User> getUsers() {
        return users == null ? new ArrayList<>() : users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
    public List<Comment> getComments() {
        return comments == null ? new ArrayList<>() : comments;
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
}
