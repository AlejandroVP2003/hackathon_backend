package com.hackathon.backend_hackathon.domain.ports;

import java.util.List;
import java.util.Optional;

import com.hackathon.backend_hackathon.domain.models.Comment;

public interface CommentRepository {
    Optional<Comment> findById(int id);
    void save(Comment comment);

    List<Comment> findAllById(List<Integer> ids);
}
