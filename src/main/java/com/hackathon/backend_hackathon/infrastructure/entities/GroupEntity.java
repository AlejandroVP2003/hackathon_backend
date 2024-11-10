package com.hackathon.backend_hackathon.infrastructure.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "grupos")
public class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grupo_id")
    private int id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "descripcion")
    private String description;
    @Column(name = "codigo_grupo")
    private String code;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UserEntity owner;
    @ManyToMany
    @JoinTable(name = "usuariosgrupos",
        joinColumns = @JoinColumn(name = "grupo_id"),
        inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<UserEntity> members;
    
    // Constructors
    public GroupEntity() {}

    public GroupEntity(int id, String name, String description, String code, UserEntity owner, List<UserEntity> members) {
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
    public UserEntity getOwner() {
        return owner;
    }
    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }
    public List<UserEntity> getMembers() {
        return members;
    }
    public void setMembers(List<UserEntity> members) {
        this.members = members;
    }

}
