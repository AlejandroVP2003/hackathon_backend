package com.hackathon.backend_hackathon.application.dtos;

import java.util.Date;

public class CommentDto {
    
    // Attributes
    private int id;
    private String content;
    private UserGroupDto user;
    private String event;
    private Date postDate;
    
    // Constructors
    public CommentDto() {}

    public CommentDto(int id, String content, UserGroupDto user, String event, Date postDate) {
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
    public UserGroupDto getUser() {
        return user;
    }
    public void setUser(UserGroupDto user) {
        this.user = user;
    }
    public String getEvent() {
        return event;
    }
    public void setEvent(String event) {
        this.event = event;
    }
    public Date getPostDate() {
        return postDate;
    }
    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

}
