package com.hackathon.backend_hackathon.domain.models;

import java.util.Date;

public class Comment {
    
    // Attributes
    private int id;
    private String content;
    private User user;
    private Event event;
    private Date postDate;
    
    // Constructors
    public Comment() {}

    public Comment(int id, String content, User user, Event event, Date postDate) {
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
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Event getEvent() {
        return event;
    }
    public void setEvent(Event event) {
        this.event = event;
    }
    public Date getPostDate() {
        return postDate;
    }
    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
    
}
