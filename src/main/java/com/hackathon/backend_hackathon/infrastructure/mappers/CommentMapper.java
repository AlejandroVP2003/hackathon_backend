package com.hackathon.backend_hackathon.infrastructure.mappers;

import com.hackathon.backend_hackathon.domain.models.Comment;
import com.hackathon.backend_hackathon.domain.models.Event;
import com.hackathon.backend_hackathon.domain.models.User;
import com.hackathon.backend_hackathon.infrastructure.entities.CommentEntity;
import com.hackathon.backend_hackathon.infrastructure.entities.EventEntity;
import com.hackathon.backend_hackathon.infrastructure.entities.UserEntity;

public class CommentMapper {

    public static CommentEntity toCommentEntity(Comment comment, boolean deep) {
        if (comment == null) {
            return null;
        }

        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setId(comment.getId());
        commentEntity.setContent(comment.getContent());
        commentEntity.setPostDate(comment.getPostDate());

        if (deep) {
            commentEntity.setUser(toUserEntity(comment.getUser(), false));
            commentEntity.setEvent(toEventEntity(comment.getEvent(), false));
        }

        return commentEntity;
    }

    private static UserEntity toUserEntity(User user, boolean deep) {
        return UserMapper.toUserEntity(user, deep);
    }

    private static EventEntity toEventEntity(Event event, boolean deep) {
        return EventMapper.toEventEntity(event, deep);
    }

    public static Comment toComment(CommentEntity commentEntity, boolean deep) {
        if (commentEntity == null) {
            return null;
        }

        Comment comment = new Comment();
        comment.setId(commentEntity.getId());
        comment.setContent(commentEntity.getContent());
        comment.setPostDate(commentEntity.getPostDate());

        if (deep) {
            comment.setUser(toUser(commentEntity.getUser(), false));
            comment.setEvent(toEvent(commentEntity.getEvent(), false));
        }

        return comment;
    }

    private static User toUser(UserEntity userEntity, boolean deep) {
        return UserMapper.toUser(userEntity, deep);
    }

    private static Event toEvent(EventEntity eventEntity, boolean deep) {
        return EventMapper.toEvent(eventEntity, deep);
    }
    
}
