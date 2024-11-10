package com.hackathon.backend_hackathon.application.dtos.create;

import java.util.Date;

public class CommentCreateDto {
    
    // Attributes
    private int id;
    private String content;
    private int user;
    private int event;
    private Date postDate;
    
    // Constructors
    public CommentCreateDto() {}

    public CommentCreateDto(int id, String content, int user, int event, Date postDate) {
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
    public int getUser() {
        return user;
    }
    public void setUser(int user) {
        this.user = user;
    }
    public int getEvent() {
        return event;
    }
    public void setEvent(int event) {
        this.event = event;
    }
    public Date getPostDate() {
        return postDate;
    }
    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

}
