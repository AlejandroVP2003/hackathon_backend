package com.hackathon.backend_hackathon.infrastructure.mappers;

import java.util.ArrayList;
import java.util.List;

import com.hackathon.backend_hackathon.domain.models.Group;
import com.hackathon.backend_hackathon.domain.models.User;
import com.hackathon.backend_hackathon.infrastructure.entities.GroupEntity;
import com.hackathon.backend_hackathon.infrastructure.entities.UserEntity;

public class GroupMapper {

    public static GroupEntity toGroupEntity(Group group, boolean deep) {
        if (group == null) {
            return null;
        }

        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setId(group.getId());
        groupEntity.setName(group.getName());
        groupEntity.setDescription(group.getDescription());
        groupEntity.setCode(group.getCode());

        if (deep) {
            groupEntity.setOwner(toUserEntity(group.getOwner(), false));

            List<UserEntity> memberEntities = new ArrayList<>();
            for (User member : group.getMembers()) {
                memberEntities.add(toUserEntity(member, false));
            }
            groupEntity.setMembers(memberEntities);
        }

        return groupEntity;
    }

    private static UserEntity toUserEntity(User user, boolean deep) {
        return UserMapper.toUserEntity(user, deep);
    }

    public static Group toGroup(GroupEntity groupEntity, boolean deep) {
        if (groupEntity == null) {
            return null;
        }

        Group group = new Group();
        group.setId(groupEntity.getId());
        group.setName(groupEntity.getName());
        group.setDescription(groupEntity.getDescription());
        group.setCode(groupEntity.getCode());

        if (deep) {
            group.setOwner(toUser(groupEntity.getOwner(), false));

            List<User> members = new ArrayList<>();
            for (UserEntity memberEntity : groupEntity.getMembers()) {
                members.add(toUser(memberEntity, false));
            }
            group.setMembers(members);
        }

        return group;
    }

    private static User toUser(UserEntity userEntity, boolean deep) {
        return UserMapper.toUser(userEntity, deep);
    }
    
}
