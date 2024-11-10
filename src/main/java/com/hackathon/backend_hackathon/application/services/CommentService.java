package com.hackathon.backend_hackathon.application.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hackathon.backend_hackathon.application.dtos.CommentDto;
import com.hackathon.backend_hackathon.application.dtos.UserGroupDto;
import com.hackathon.backend_hackathon.application.dtos.create.CommentCreateDto;
import com.hackathon.backend_hackathon.domain.models.Comment;
import com.hackathon.backend_hackathon.domain.models.Event;
import com.hackathon.backend_hackathon.domain.models.User;
import com.hackathon.backend_hackathon.domain.ports.CommentRepository;
import com.hackathon.backend_hackathon.domain.ports.EventRepository;
import com.hackathon.backend_hackathon.domain.ports.UserRepository;

@Service
public class CommentService {
    
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public CommentService(CommentRepository commentRepository, UserRepository userRepository, EventRepository eventRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    public Optional<CommentDto> getCommentById(int id) {
        return commentRepository.findById(id)
            .map(this::toDto);
    }

    private CommentDto toDto(Comment comment) {
        if (comment == null) {
            return null;
        }
        
        UserGroupDto userDto = toUserGroupDto(comment.getUser());
        String eventName = comment.getEvent().getName();
        
        return new CommentDto(
            comment.getId(),
            comment.getContent(),
            userDto,
            eventName,
            comment.getPostDate()
        );
    }

    private UserGroupDto toUserGroupDto(User user) {
        if (user == null) {
            return null;
        }
        return new UserGroupDto(user.getName(), user.getLastName1(), user.getLastName2()
        );
    }

    public void createComment(CommentCreateDto commentCreateDto) {
        Comment comment = new Comment();
        comment.setContent(commentCreateDto.getContent());
        comment.setPostDate(commentCreateDto.getPostDate());

        User user = userRepository.findById(commentCreateDto.getUser()).orElseThrow(() -> new RuntimeException("User not found with id: " + commentCreateDto.getUser()));;
        comment.setUser(user);

        Event event = eventRepository.findById(commentCreateDto.getEvent()).orElseThrow(() -> new RuntimeException("User not found with id: " + commentCreateDto.getUser()));;
        comment.setEvent(event);

        commentRepository.save(comment);
    }

}
