package com.hackathon.backend_hackathon.infrastructure.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackathon.backend_hackathon.infrastructure.entities.UserEntity;

public interface UserPersistance extends JpaRepository<UserEntity, Integer> {
    
}
