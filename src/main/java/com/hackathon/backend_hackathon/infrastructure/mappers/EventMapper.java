package com.hackathon.backend_hackathon.infrastructure.mappers;

import java.util.ArrayList;
import java.util.List;

import com.hackathon.backend_hackathon.domain.models.Comment;
import com.hackathon.backend_hackathon.domain.models.Event;
import com.hackathon.backend_hackathon.domain.models.User;
import com.hackathon.backend_hackathon.infrastructure.entities.CommentEntity;
import com.hackathon.backend_hackathon.infrastructure.entities.EventEntity;
import com.hackathon.backend_hackathon.infrastructure.entities.UserEntity;

public class EventMapper {

    public static EventEntity toEventEntity(Event event, boolean deep) {
        if (event == null) {
            return null;
        }

        EventEntity eventEntity = new EventEntity();
        eventEntity.setId(event.getId());
        eventEntity.setName(event.getName());
        eventEntity.setDescription(event.getDescription());
        eventEntity.setStartDate(event.getStartDate());
        eventEntity.setEndDate(event.getEndDate());
        eventEntity.setType(event.getType());
        eventEntity.setLatitude(event.getLatitude());
        eventEntity.setLongitude(event.getLongitude());

        if (deep) {
            List<UserEntity> userEntities = new ArrayList<>();
            for (User user : event.getUsers()) {
                userEntities.add(toUserEntity(user, false));
            }
            eventEntity.setUsers(userEntities);

            List<CommentEntity> commentEntities = new ArrayList<>();
            for (Comment comment : event.getComments()) {
                commentEntities.add(toCommentEntity(comment, false));
            }
            eventEntity.setComments(commentEntities);
        }
        eventEntity.setKey(event.getKey());

        return eventEntity;
    }

    private static UserEntity toUserEntity(User user, boolean deep) {
        return UserMapper.toUserEntity(user, deep);
    }

    private static CommentEntity toCommentEntity(Comment comment, boolean deep) {
        return CommentMapper.toCommentEntity(comment, deep);
    }

    public static Event toEvent(EventEntity eventEntity, boolean deep) {
        if (eventEntity == null) {
            return null;
        }

        Event event = new Event();
        event.setId(eventEntity.getId());
        event.setName(eventEntity.getName());
        event.setDescription(eventEntity.getDescription());
        event.setStartDate(eventEntity.getStartDate());
        event.setEndDate(eventEntity.getEndDate());
        event.setType(eventEntity.getType());
        event.setLatitude(eventEntity.getLatitude());
        event.setLongitude(eventEntity.getLongitude());

        if (deep) {
            List<User> users = new ArrayList<>();
            for (UserEntity userEntity : eventEntity.getUsers()) {
                users.add(toUser(userEntity, false));
            }
            event.setUsers(users);

            List<Comment> comments = new ArrayList<>();
            for (CommentEntity commentEntity : eventEntity.getComments()) {
                comments.add(toComment(commentEntity, false));
            }
            event.setComments(comments);
        }
        event.setKey(eventEntity.getKey());

        return event;
    }

    private static User toUser(UserEntity userEntity, boolean deep) {
        return UserMapper.toUser(userEntity, deep);
    }

    private static Comment toComment(CommentEntity commentEntity, boolean deep) {
        return CommentMapper.toComment(commentEntity, deep);
    }
    
}
