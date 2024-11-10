package com.hackathon.backend_hackathon.application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hackathon.backend_hackathon.application.dtos.EventDto;
import com.hackathon.backend_hackathon.application.dtos.EventLocationDto;
import com.hackathon.backend_hackathon.application.dtos.UserGroupDto;
import com.hackathon.backend_hackathon.application.dtos.create.EventCreateDto;
import com.hackathon.backend_hackathon.domain.models.Event;
import com.hackathon.backend_hackathon.domain.models.User;
import com.hackathon.backend_hackathon.domain.ports.EventRepository;
import com.hackathon.backend_hackathon.domain.ports.UserRepository;

@Service
public class EventService {
    
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public EventService(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    public Optional<EventDto> getEventById(int id) {
        return eventRepository.findById(id)
            .map(this::toEventDto);
    }

    public Optional<EventLocationDto> getEventLocation(int id) {
        return eventRepository.findById(id)
            .map(this::toEventLocationDto);
    }

    private EventDto toEventDto(Event event) {
        if (event == null) {
            return null;
        }

        List<UserGroupDto> userDtos = new ArrayList<>();
        if (event.getUsers() != null) {
            for (User user : event.getUsers()) {
                userDtos.add(toUserGroupDto(user));
            }
        }

        return new EventDto(event.getId(), event.getName(), event.getDescription(), event.getStartDate(), event.getEndDate(), event.getType(), userDtos);
    }

    private UserGroupDto toUserGroupDto(User user) {
        if (user == null) {
            return null;
        }

        return new UserGroupDto(user.getName(), user.getLastName1(), user.getLastName2());
    }

    private EventLocationDto toEventLocationDto(Event event) {
        if (event == null) {
            return null;
        }

        return new EventLocationDto(event.getId(), event.getName(), event.getType() ,event.getLatitude(), event.getLongitude(), event.getKey());
    }

    public void createEvent(EventCreateDto eventCreateDto) {
        Event event = new Event();
        event.setName(eventCreateDto.getName());
        event.setDescription(eventCreateDto.getDescription());
        event.setStartDate(eventCreateDto.getStartDate());
        event.setEndDate(eventCreateDto.getEndDate());
        event.setType(eventCreateDto.getType());
        event.setLatitude(eventCreateDto.getLatitude());
        event.setLongitude(eventCreateDto.getLongitude());

        List<User> users = userRepository.findAllById(eventCreateDto.getUsers());
        event.setUsers(users);

        eventRepository.save(event);
    }

    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepository.findAll();

        List<EventDto> eventDtos = events.stream()
                .map(this::toEventDto)
                .collect(Collectors.toList());

        return eventDtos;
    }

}
