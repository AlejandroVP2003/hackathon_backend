package com.hackathon.backend_hackathon.infrastructure.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "eventos")
public class EventEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evento_id")
    private int id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "descripcion")
    private String description;
    @Column(name = "fecha_inicio")
    private Date startDate;
    @Column(name = "fecha_fin")
    private Date endDate;
    @Column(name = "tipo")
    private int type;
    @Column(name = "ubicacion_latitud")
    private double latitude;
    @Column(name = "ubicacion_longitud")
    private double longitude;

    @ManyToMany
    @JoinTable(
        name = "usuarioseventos",
        joinColumns = @JoinColumn(name = "evento_id"),
        inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<UserEntity> users;
    @OneToMany(mappedBy = "event")
    private List<CommentEntity> comments;
    @Column(name = "llave")
    private String key;

    // Constructors
    public EventEntity() {}

    public EventEntity(int id, String name, String description, Date startDate, Date endDate, int type, double latitude,
            double longitude, List<UserEntity> users, List<CommentEntity> comments, String key) {
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
    public List<UserEntity> getUsers() {
        return users;
    }
    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
    public List<CommentEntity> getComments() {
        return comments;
    }
    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }

}

