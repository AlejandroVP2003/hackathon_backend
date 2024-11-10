package com.hackathon.backend_hackathon.application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hackathon.backend_hackathon.application.dtos.GroupDto;
import com.hackathon.backend_hackathon.application.dtos.UserGroupDto;
import com.hackathon.backend_hackathon.application.dtos.create.GroupCreateDto;
import com.hackathon.backend_hackathon.domain.models.Group;
import com.hackathon.backend_hackathon.domain.models.User;
import com.hackathon.backend_hackathon.domain.ports.GroupRepository;
import com.hackathon.backend_hackathon.domain.ports.UserRepository;

@Service
public class GroupService {
    
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    public GroupService(GroupRepository groupRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    public Optional<GroupDto> getGroupById(int id) {
        return groupRepository.findById(id)
            .map(this::toGroupDto);
    }

    private GroupDto toGroupDto(Group group) {
        if (group == null) {
            return null;
        }

        UserGroupDto ownerDto = null;
        if (group.getOwner() != null) {
            ownerDto = toUserGroupDto(group.getOwner());
        }

        List<UserGroupDto> memberDtos = new ArrayList<>();
        if (group.getMembers() != null) {
            for (User member : group.getMembers()) {
                memberDtos.add(toUserGroupDto(member));
            }
        }

        return new GroupDto(group.getId(), group.getName(), group.getDescription(), group.getCode(), ownerDto, memberDtos);
    }
    
    private UserGroupDto toUserGroupDto(User user) {
        if (user == null) {
            return null;
        }
        return new UserGroupDto(user.getName(), user.getLastName1(), user.getLastName2());
    }

    public void createGroup(GroupCreateDto groupCreateDto) {
        User owner = userRepository.findById(groupCreateDto.getOwner())
                                   .orElseThrow(() -> new RuntimeException("Owner not found"));

        List<User> members = userRepository.findAllById(groupCreateDto.getMembers());

        Group group = new Group();
        group.setName(groupCreateDto.getName());
        group.setDescription(groupCreateDto.getDescription());
        group.setOwner(owner);
        group.setMembers(members);

        groupRepository.save(group);
    }

    public void addUserToGroup(int groupId, int userId) {
        Group group = groupRepository.findById(groupId)
            .orElseThrow(() -> new RuntimeException("Group not found"));

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

        group.getMembers().add(user);

        groupRepository.save(group);
    }
}

