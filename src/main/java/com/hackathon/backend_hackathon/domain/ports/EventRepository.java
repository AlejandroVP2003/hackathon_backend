package com.hackathon.backend_hackathon.domain.ports;

import java.util.List;
import java.util.Optional;

import com.hackathon.backend_hackathon.domain.models.Event;

public interface EventRepository {
    Optional<Event> findById(int id);
    void save(Event event);

    List<Event> findAll();
}
