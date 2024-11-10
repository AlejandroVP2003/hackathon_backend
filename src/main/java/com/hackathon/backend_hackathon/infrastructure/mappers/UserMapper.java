package com.hackathon.backend_hackathon.infrastructure.mappers;

import java.util.ArrayList;
import java.util.List;

import com.hackathon.backend_hackathon.domain.models.Comment;
import com.hackathon.backend_hackathon.domain.models.Event;
import com.hackathon.backend_hackathon.domain.models.Group;
import com.hackathon.backend_hackathon.domain.models.User;
import com.hackathon.backend_hackathon.infrastructure.entities.CommentEntity;
import com.hackathon.backend_hackathon.infrastructure.entities.EventEntity;
import com.hackathon.backend_hackathon.infrastructure.entities.GroupEntity;
import com.hackathon.backend_hackathon.infrastructure.entities.UserEntity;

public class UserMapper {

    public static UserEntity toUserEntity(User user, boolean deep) {
        if (user == null) {
            return null;
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setDni(user.getDni());
        userEntity.setName(user.getName());
        userEntity.setLastName1(user.getLastName1());
        userEntity.setLastName2(user.getLastName2());
        userEntity.setDateBirth(user.getDateBirth());
        userEntity.setPhone(user.getPhone());
        userEntity.setEmail(user.getEmail());
        userEntity.setType(user.getType());
        userEntity.setPassword(user.getPassword());

        if (deep) {
            List<GroupEntity> groupEntities = new ArrayList<>();
            for (Group group : user.getGroups()) {
                groupEntities.add(toGroupEntity(group, false));
            }
            userEntity.setGroups(groupEntities);

            List<CommentEntity> commentEntities = new ArrayList<>();
            for (Comment comment : user.getComments()) {
                commentEntities.add(toCommentEntity(comment, false));
            }
            userEntity.setComments(commentEntities);

            List<EventEntity> eventEntities = new ArrayList<>();
            for (Event event : user.getEvents()) {
                eventEntities.add(toEventEntity(event, false));
            }
            userEntity.setEvents(eventEntities);
        }

        return userEntity;
    }

    private static GroupEntity toGroupEntity(Group group, boolean deep) {
        return GroupMapper.toGroupEntity(group, deep);
    }

    private static CommentEntity toCommentEntity(Comment comment, boolean deep) {
        return CommentMapper.toCommentEntity(comment, deep);
    }

    private static EventEntity toEventEntity(Event event, boolean deep) {
        return EventMapper.toEventEntity(event, deep);
    }
    
    public static User toUser(UserEntity userEntity, boolean deep) {
        if (userEntity == null) {
            return null;
        }

        User user = new User();
        user.setId(userEntity.getId());
        user.setDni(userEntity.getDni());
        user.setName(userEntity.getName());
        user.setLastName1(userEntity.getLastName1());
        user.setLastName2(userEntity.getLastName2());
        user.setDateBirth(userEntity.getDateBirth());
        user.setPhone(userEntity.getPhone());
        user.setEmail(userEntity.getEmail());
        user.setType(userEntity.getType());
        user.setPassword(userEntity.getPassword());

        if (deep) {
            List<Group> groups = new ArrayList<>();
            for (GroupEntity groupEntity : userEntity.getGroups()) {
                groups.add(toGroup(groupEntity, false));
            }
            user.setGroups(groups);

            List<Comment> comments = new ArrayList<>();
            for (CommentEntity commentEntity : userEntity.getComments()) {
                comments.add(toComment(commentEntity, false));
            }
            user.setComments(comments);

            List<Event> events = new ArrayList<>();
            for (EventEntity eventEntity : userEntity.getEvents()) {
                events.add(toEvent(eventEntity, false));
            }
            user.setEvents(events);
        }

        return user;
    }

    private static Group toGroup(GroupEntity groupEntity, boolean deep) {
        return GroupMapper.toGroup(groupEntity, deep);
    }

    private static Comment toComment(CommentEntity commentEntity, boolean deep) {
        return CommentMapper.toComment(commentEntity, deep);
    }

    private static Event toEvent(EventEntity eventEntity, boolean deep) {
        return EventMapper.toEvent(eventEntity, deep);
    }
    
}
