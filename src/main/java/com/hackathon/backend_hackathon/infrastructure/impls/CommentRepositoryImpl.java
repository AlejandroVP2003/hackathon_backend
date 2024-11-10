package com.hackathon.backend_hackathon.infrastructure.impls;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.hackathon.backend_hackathon.domain.models.Comment;
import com.hackathon.backend_hackathon.domain.ports.CommentRepository;
import com.hackathon.backend_hackathon.infrastructure.entities.CommentEntity;
import com.hackathon.backend_hackathon.infrastructure.mappers.CommentMapper;
import com.hackathon.backend_hackathon.infrastructure.persistance.CommentPersistance;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

    private final CommentPersistance commentPersistance;

    public CommentRepositoryImpl(CommentPersistance commentPersistance) {
        this.commentPersistance = commentPersistance;
    }

    @Override
    public Optional<Comment> findById(int id) {
        return commentPersistance.findById(id)
            .map(this::toDomain);
    }

    private Comment toDomain(CommentEntity entity) {
        new CommentMapper();
        return CommentMapper.toComment(entity, true);
    }

    @Override
    public List<Comment> findAllById(List<Integer> ids) {
        List<CommentEntity> commentEntities = commentPersistance.findAll();
        return commentEntities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void save(Comment comment) {
        CommentEntity commentEntity = CommentMapper.toCommentEntity(comment,true);
        commentPersistance.save(commentEntity);
    }
    
}
