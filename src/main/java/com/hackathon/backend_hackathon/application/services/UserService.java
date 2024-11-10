package com.hackathon.backend_hackathon.application.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hackathon.backend_hackathon.application.dtos.GroupDto;
import com.hackathon.backend_hackathon.application.dtos.UserDto;
import com.hackathon.backend_hackathon.domain.models.Group;
import com.hackathon.backend_hackathon.domain.models.User;
import com.hackathon.backend_hackathon.domain.ports.GroupRepository;
import com.hackathon.backend_hackathon.domain.ports.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    public UserService(UserRepository userRepository, GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }

    public Optional<UserDto> getUserById(int id) {
        return userRepository.findById(id)
            .map(this::toDto);
    }

    private UserDto toDto(User user) {
        if (user == null) {
            return null;
        }
        return new UserDto(user.getId(), user.getName(), user.getLastName1(), user.getLastName2(), user.getPhone(), user.getEmail());
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public List<GroupDto> getGroupsPerUser(int id) {
        List<Group> groups = groupRepository.findGroupsByUserId(id);

        List<GroupDto> groupDtos = groups.stream()
                .map(this::toGroupDto)
                .collect(Collectors.toList());

        return groupDtos;
    }

    private GroupDto toGroupDto(Group group) {
        GroupDto groupDto = new GroupDto();
        groupDto.setId(group.getId());
        groupDto.setName(group.getName());
        groupDto.setDescription(group.getDescription());

        return groupDto;
    }

    public void joinGroup(int userId, int groupId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

        Group group = groupRepository.findById(groupId)
            .orElseThrow(() -> new RuntimeException("Group not found"));

        user.getGroups().add(group);
        group.getMembers().add(user);

        userRepository.save(user);
        groupRepository.save(group);

    }

}
