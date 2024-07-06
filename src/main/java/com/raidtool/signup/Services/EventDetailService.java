package com.raidtool.signup.Services;

import com.raidtool.signup.Entities.EventDetail;
import com.raidtool.signup.Repositories.EventDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventDetailService implements IService<EventDetail> {

    EventDetailRepository eventDetailRepository;

    @Autowired
    public EventDetailService(EventDetailRepository eventDetailRepository) {
        this.eventDetailRepository = eventDetailRepository;
    }

    @Override
    public List<EventDetail> get() {
        return eventDetailRepository.get();
    }

    @Override
    public EventDetail getById(int id) {
        return eventDetailRepository.getById(id);
    }

    @Override
    public void add(EventDetail eventDetail) {
        eventDetailRepository.add(eventDetail);
    }

    @Override
    public void update(EventDetail eventDetail) {
        eventDetailRepository.update(eventDetail);
    }

    @Override
    public void delete(EventDetail eventDetail) {
        eventDetailRepository.delete(eventDetail);
    }
}
