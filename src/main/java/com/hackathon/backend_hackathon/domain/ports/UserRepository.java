package com.hackathon.backend_hackathon.domain.ports;

import java.util.List;
import java.util.Optional;

import com.hackathon.backend_hackathon.domain.models.User;

public interface UserRepository {
    Optional<User> findById(int id);
    void save(User user);

    List<User> findAllById(List<Integer> ids);
}
