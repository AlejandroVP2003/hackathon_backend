package com.hackathon.backend_hackathon.domain.ports;

import java.util.List;
import java.util.Optional;

import com.hackathon.backend_hackathon.domain.models.Group;

public interface GroupRepository {
    Optional<Group> findById(int id);
    void save(Group group);

    List<Group> findGroupsByUserId(int id);
    Optional<Group> findByCode(String code);
}
