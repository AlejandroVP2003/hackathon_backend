package com.hackathon.backend_hackathon.infrastructure.impls;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.hackathon.backend_hackathon.domain.models.Group;
import com.hackathon.backend_hackathon.domain.ports.GroupRepository;
import com.hackathon.backend_hackathon.infrastructure.entities.GroupEntity;
import com.hackathon.backend_hackathon.infrastructure.entities.UserEntity;
import com.hackathon.backend_hackathon.infrastructure.mappers.GroupMapper;
import com.hackathon.backend_hackathon.infrastructure.persistance.GroupPersistance;

@Repository
public class GroupRepositoryImpl implements GroupRepository {

    private final GroupPersistance groupPersistance;

    public GroupRepositoryImpl(GroupPersistance groupPersistance) {
        this.groupPersistance = groupPersistance;
    }

    @Override
    public Optional<Group> findById(int id) {
        return groupPersistance.findById(id)
            .map(this::toDomain);
    }

    private Group toDomain(GroupEntity entity) {
        new GroupMapper();
        return GroupMapper.toGroup(entity, true);
    }
    
    @Override
    public void save(Group group) {
        GroupEntity groupEntity = GroupMapper.toGroupEntity(group, true);
        groupPersistance.save(groupEntity);
    }

    @Override
    public List<Group> findGroupsByUserId(int id) {
        List<GroupEntity> groupEntities = groupPersistance.findByMembers(new UserEntity(id, null, null, null, null, null, null, null, 1, null, null, null, null));

        return groupEntities.stream()
            .map(this::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Group> findByCode(String code) {
        return groupPersistance.findByCode(code)
            .map(this::toDomain);
    }
    
}
