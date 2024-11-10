package com.hackathon.backend_hackathon.infrastructure.persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hackathon.backend_hackathon.infrastructure.entities.GroupEntity;
import com.hackathon.backend_hackathon.infrastructure.entities.UserEntity;

public interface GroupPersistance extends JpaRepository<GroupEntity, Integer> {
    
    List<GroupEntity> findByMembers(UserEntity user);
    @Query("SELECT g FROM GroupEntity g WHERE g.code = :code")
    Optional<GroupEntity> findByCode(@Param("code") String code);
}
