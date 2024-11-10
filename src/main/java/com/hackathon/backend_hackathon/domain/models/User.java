package com.hackathon.backend_hackathon.domain.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    
    // Attributes
    private int id;
    private String dni;
    private String name;
    private String lastName1;
    private String lastName2;
    private LocalDate dateBirth;
    private String phone;
    private String email;
    private int type;
    private String password;
    private List<Group> groups;
    private List<Comment> comments;
    private List<Event> events;
    
    // Constructors
    public User() {}

    public User(int id, String dni, String name, String lastName1, String lastName2, LocalDate dateBirth, String phone,
            String email, int type, String password, List<Group> groups, List<Comment> comments, List<Event> events) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
        this.dateBirth = dateBirth;
        this.phone = phone;
        this.email = email;
        this.type = type;
        this.password = password;
        this.groups = groups;
        this.comments = comments;
        this.events = events;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
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
    public LocalDate getDateBirth() {
        return dateBirth;
    }
    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<Group> getGroups() {
        return groups == null ? new ArrayList<>() : groups;
    }
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
    public List<Comment> getComments() {
        return comments == null ? new ArrayList<>() : comments;
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    public List<Event> getEvents() {
        return events == null ? new ArrayList<>() : events;
    }
    public void setEvents(List<Event> events) {
        this.events = events;
    }
    
}
