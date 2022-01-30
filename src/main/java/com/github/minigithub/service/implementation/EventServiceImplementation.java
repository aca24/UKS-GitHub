package com.github.minigithub.service.implementation;

import java.time.LocalDateTime;
import java.util.List;

import com.github.minigithub.dto.EventDTO;
import com.github.minigithub.model.Event;
import com.github.minigithub.repository.EventRepository;
import com.github.minigithub.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImplementation implements EventService {

    private EventRepository eventRepository;

    @Autowired
    public EventServiceImplementation(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event findOne(Long id) {
        return eventRepository.findById(id).orElseGet(null);
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Page<Event> findAll(Pageable page) {
        return eventRepository.findAll(page);
    }

    public Event save(EventDTO eventDTO) {
        Event event = new Event();

        try {
            event.setCreationTime(LocalDateTime.now());
            // event.setTask();
            event = eventRepository.save(event);
        } catch (Exception e) {
            return null;
        }

        return event;
    }

    public void remove(Long id) {
        eventRepository.deleteById(id);
    }
}