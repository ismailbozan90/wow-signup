package com.raidtool.signup.Controllers;

import com.raidtool.signup.DTO.EventDTO;
import com.raidtool.signup.Entities.Event;
import com.raidtool.signup.Services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EventController {


    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Event methods
    @GetMapping("events")
    public ResponseEntity<List<EventDTO>> getEvents() {
        List<EventDTO> result = eventService.getEvents();
        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("events/{id}")
    public ResponseEntity<EventDTO> getEvent(@PathVariable Long id) {
        Optional<EventDTO> event = eventService.getById(id);
        return event.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping("events")
    public ResponseEntity<Boolean> addEvent(@RequestBody Event event) {
        Boolean result = eventService.addEvent(event);
        if (!result) {
            return new ResponseEntity<>(false, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }

    @DeleteMapping("events/{id}")
    public ResponseEntity<Boolean> deleteEvent(@PathVariable Long id) {
        Boolean result = eventService.deleteEvent(id);
        if (!result) {
            return new ResponseEntity<>(false, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);

    }

    @PutMapping("events")
    public ResponseEntity<Boolean> updateEvent(@RequestBody Event event) {
        Boolean result = eventService.updateEvent(event);
        if (!result) {
            return new ResponseEntity<>(false, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
