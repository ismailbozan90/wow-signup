package com.raidtool.signup.Services;

import com.raidtool.signup.DTO.EventDTO;
import com.raidtool.signup.Entities.Event;
import com.raidtool.signup.Repositories.EventRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EventService(EventRepository eventRepository, ModelMapper modelMapper) {
        this.eventRepository = eventRepository;
        this.modelMapper = modelMapper;
    }

    public List<EventDTO> getEvents() {
        List<Event> eventList = eventRepository.getEvents();
        return eventList.stream().map(event-> modelMapper.map(event, EventDTO.class)).toList();
    }

    public Optional<EventDTO> getById(Long id) {
        Event event = eventRepository.getById(id);
        if (event == null) {
            return Optional.empty();
        }
        return Optional.of(modelMapper.map(event, EventDTO.class));
    }

    public Boolean addEvent(Event event) {
        return eventRepository.addEvent(event);
    }

    public Boolean updateEvent(Event event) {
        return eventRepository.updateEvent(event);
    }

    public Boolean deleteEvent(Long id) {
        return eventRepository.deleteEvent(id);
    }
}
