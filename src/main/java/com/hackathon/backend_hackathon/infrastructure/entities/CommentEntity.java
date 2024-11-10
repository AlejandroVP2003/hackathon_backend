package com.hackathon.backend_hackathon.infrastructure.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comentarios")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comentario_id")
    private int id;
    @Column(name = "contenido")
    private String content;
    @ManyToOne
    @JoinColumn(name = "usuario_id") 
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private EventEntity event;
    @Column(name = "fecha")
    private Date postDate;
    
    // Constructors
    public CommentEntity() {}

    public CommentEntity(int id, String content, UserEntity user, EventEntity event, Date postDate) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.event = event;
        this.postDate = postDate;
    }
    
    // Getters & Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public UserEntity getUser() {
        return user;
    }
    public void setUser(UserEntity user) {
        this.user = user;
    }
    public EventEntity getEvent() {
        return event;
    }
    public void setEvent(EventEntity event) {
        this.event = event;
    }
    public Date getPostDate() {
        return postDate;
    }
    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

}
