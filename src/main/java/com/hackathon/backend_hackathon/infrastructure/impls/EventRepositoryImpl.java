package com.hackathon.backend_hackathon.infrastructure.impls;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.hackathon.backend_hackathon.domain.models.Event;
import com.hackathon.backend_hackathon.domain.ports.EventRepository;
import com.hackathon.backend_hackathon.infrastructure.entities.EventEntity;
import com.hackathon.backend_hackathon.infrastructure.mappers.EventMapper;
import com.hackathon.backend_hackathon.infrastructure.persistance.EventPersistance;

@Repository
public class EventRepositoryImpl implements EventRepository {

    private final EventPersistance eventPersistance;

    public EventRepositoryImpl(EventPersistance eventPersistance) {
        this.eventPersistance = eventPersistance;
    }

    @Override
    public Optional<Event> findById(int id) {
        return eventPersistance.findById(id)
            .map(this::toDomain);
    }

    private Event toDomain(EventEntity entity) {
        new EventMapper();
        return EventMapper.toEvent(entity, true);
    }

    @Override
    public void save(Event event) {
        EventEntity eventEntity = EventMapper.toEventEntity(event, true);
        eventPersistance.save(eventEntity);
    }

    @Override
    public List<Event> findAll() {
        List<EventEntity> eventEntities = eventPersistance.findAll();
        return eventEntities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
    
}
