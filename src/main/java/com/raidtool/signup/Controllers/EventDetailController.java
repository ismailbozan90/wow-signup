package com.raidtool.signup.Controllers;

import com.raidtool.signup.DTO.EventDetailDTO;
import com.raidtool.signup.Entities.EventDetail;
import com.raidtool.signup.Services.EventDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EventDetailController {


    private final EventDetailService eventDetailService;

    @Autowired
    public EventDetailController(EventDetailService eventDetailService) {
        this.eventDetailService = eventDetailService;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Character methods
    @GetMapping("event-details")
    public ResponseEntity<List<EventDetailDTO>> getEventDetails() {
        List<EventDetailDTO> list = eventDetailService.getEventDetails();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("event-details/{id}")
    public ResponseEntity<EventDetailDTO> getEventDetail(@PathVariable Long id) {
        Optional<EventDetailDTO> eventDetail = eventDetailService.getById(id);
        return eventDetail.map(detail -> new ResponseEntity<>(detail, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping("event-details")
    public ResponseEntity<Boolean> addEventDetail(@RequestBody EventDetail eventDetail) {
        Boolean result = eventDetailService.addEventDetail(eventDetail);
        if (!result) {
            return new ResponseEntity<>(false, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }

    @DeleteMapping("event-details/{id}")
    public ResponseEntity<Boolean> deleteEventDetail(@PathVariable Long id) {
        Boolean result = eventDetailService.deleteEventDetail(id);
        if (!result) {
            return new ResponseEntity<>(false, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }

    @PutMapping("event-details")
    public ResponseEntity<Boolean> updateEventDetail(@RequestBody EventDetail eventDetail) {
        Boolean result = eventDetailService.updateEventDetail(eventDetail);
        if (!result) {
            return new ResponseEntity<>(false, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(true, HttpStatus.CREATED);

    }
}
