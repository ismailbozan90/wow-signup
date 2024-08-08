package com.raidtool.signup.Services;

import com.raidtool.signup.DTO.EventDetailDTO;
import com.raidtool.signup.Entities.EventDetail;
import com.raidtool.signup.Repositories.EventDetailRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventDetailService {

    private final EventDetailRepository eventDetailRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EventDetailService(EventDetailRepository eventDetailRepository, ModelMapper modelMapper) {
        this.eventDetailRepository = eventDetailRepository;
        this.modelMapper = modelMapper;
    }

    public List<EventDetailDTO> getEventDetails() {
        List<EventDetail> eventDetailList = eventDetailRepository.getEventDetails();
        return eventDetailList.stream().map(eventDetail -> modelMapper.map(eventDetail, EventDetailDTO.class)).toList();
    }

    public Optional<EventDetailDTO> getById(Long id) {
        EventDetail eventDetail = eventDetailRepository.getById(id);
        if (eventDetail == null) {
            return Optional.empty();
        }
        return Optional.of(modelMapper.map(eventDetail, EventDetailDTO.class));
    }

    public Boolean addEventDetail(EventDetail eventDetail) {
        return eventDetailRepository.addEventDetail(eventDetail);
    }

    public Boolean updateEventDetail(EventDetail eventDetail) {
        return eventDetailRepository.updateEventDetail(eventDetail);
    }

    public Boolean deleteEventDetail(Long id) {
        return eventDetailRepository.deleteEventDetail(id);
    }
}
