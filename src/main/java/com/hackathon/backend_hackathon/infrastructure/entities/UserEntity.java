package com.hackathon.backend_hackathon.infrastructure.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private int id;
    private String dni;
    @Column(name = "nombre")
    private String name;
    @Column(name = "apellido_paterno")
    private String lastName1;
    @Column(name = "apellido_materno")
    private String lastName2;
    @Column(name = "fecha_nacimiento")
    private LocalDate dateBirth;
    @Column(name = "telefono")
    private String phone;
    private String email;
    @Column(name = "tipo")
    private int type;
    private String password;
    @ManyToMany(mappedBy = "members")
    private List<GroupEntity> groups;
    @OneToMany(mappedBy = "user")
    private List<CommentEntity> comments;
    @ManyToMany(mappedBy = "users")
    private List<EventEntity> events;
    
    // Constructors
    public UserEntity() {}

    public UserEntity(int id, String dni, String name, String lastName1, String lastName2, LocalDate dateBirth, String phone,
            String email, int type, String password, List<GroupEntity> groups, List<CommentEntity> comments, List<EventEntity> events) {
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
    public List<GroupEntity> getGroups() {
        return groups == null ? new ArrayList<>() : groups;
    }
    public void setGroups(List<GroupEntity> groups) {
        this.groups = groups;
    }
    public List<CommentEntity> getComments() {
        return comments == null ? new ArrayList<>() : comments;
    }
    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }
    public List<EventEntity> getEvents() {
        return events == null ? new ArrayList<>() : events;
    }
    public void setEvents(List<EventEntity> events) {
        this.events = events;
    }
    
}
