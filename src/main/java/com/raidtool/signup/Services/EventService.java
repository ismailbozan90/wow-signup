package com.raidtool.signup.Services;

import com.raidtool.signup.Entities.Event;
import com.raidtool.signup.Repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService implements IService<Event> {

    EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> get() {
        return eventRepository.get();
    }

    @Override
    public Event getById(int id) {
        return eventRepository.getById(id);
    }

    @Override
    public void add(Event event) {
        eventRepository.add(event);
    }

    @Override
    public void update(Event event) {
        eventRepository.update(event);
    }

    @Override
    public void delete(Event event) {
        eventRepository.delete(event);
    }
}
