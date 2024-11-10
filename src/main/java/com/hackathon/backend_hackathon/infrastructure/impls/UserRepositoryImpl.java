package com.hackathon.backend_hackathon.infrastructure.impls;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.hackathon.backend_hackathon.domain.models.User;
import com.hackathon.backend_hackathon.domain.ports.UserRepository;
import com.hackathon.backend_hackathon.infrastructure.entities.UserEntity;
import com.hackathon.backend_hackathon.infrastructure.mappers.UserMapper;
import com.hackathon.backend_hackathon.infrastructure.persistance.UserPersistance;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserPersistance userPersistance;

    public UserRepositoryImpl(UserPersistance userPersistance) {
        this.userPersistance = userPersistance;
    }

    @Override
    public Optional<User> findById(int id) {
        return userPersistance.findById(id)
            .map(this::toDomain);
    }

    private User toDomain(UserEntity entity) {
        new UserMapper();
        return UserMapper.toUser(entity, true);
    }

    @Override
    public void save(User user) {
        UserEntity userEntity = UserMapper.toUserEntity(user, true);
        userPersistance.save(userEntity);
    }

    @Override
    public List<User> findAllById(List<Integer> ids) {
        List<UserEntity> userEntities = userPersistance.findAllById(ids);

        List<User> users = userEntities.stream()
            .map(this::toDomain)
            .collect(Collectors.toList());

        return users;
    }
    
}
