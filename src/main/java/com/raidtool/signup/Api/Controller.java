package com.raidtool.signup.Api;


import com.raidtool.signup.Entities.Character;
import com.raidtool.signup.Entities.Event;
import com.raidtool.signup.Entities.EventDetail;
import com.raidtool.signup.Entities.User;
import com.raidtool.signup.Services.CharacterService;
import com.raidtool.signup.Services.EventDetailService;
import com.raidtool.signup.Services.EventService;
import com.raidtool.signup.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    UserService userService;
    CharacterService characterService;
    EventService eventService;
    EventDetailService eventDetailService;

    @Autowired
    public Controller(UserService userService, CharacterService characterService, EventService eventService, EventDetailService eventDetailService) {
        this.userService = userService;
        this.characterService = characterService;
        this.eventService = eventService;
        this.eventDetailService = eventDetailService;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("login")
    public boolean login(@RequestBody User user) {
        return userService.login(user);
    }

    @GetMapping("usercharacters/{id}")
    public List<Character> getUserCharacterList(@PathVariable long id) {
        return userService.getCharacterList(id);
    }

    @GetMapping("usereventdetails/{id}")
    public List<EventDetail> getUserEventDetailList(@PathVariable long id) {
        return userService.getEventDetailList(id);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // User methods
    @GetMapping("users")
    public List<User> getUsers() {
        return userService.get();
    }

    @GetMapping("user/{id}")
    public User getUser(@PathVariable long id) {
        return userService.getById(id);
    }

    @PostMapping("adduser")
    public void addUser(@RequestBody User user) {
        userService.add(user);
    }

    @PostMapping("deleteuser")
    public void deleteUser(@RequestBody User user) {
        userService.delete(user);
    }

    @PostMapping("updateuser")
    public void updateUser(@RequestBody User user) {
        userService.update(user);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Character methods
    @GetMapping("characters")
    public List<Character> getCharacters() {
        return characterService.get();
    }

    @GetMapping("character/{id}")
    public Character getCharacter(@PathVariable long id) {
        return characterService.getById(id);
    }

    @PostMapping("addcharacter")
    public void addCharacter(@RequestBody Character character) {
        characterService.add(character);
    }

    @PostMapping("deletecharacter")
    public void deleteUser(@RequestBody Character character) {
        characterService.delete(character);
    }

    @PostMapping("updatecharacter")
    public void updateUser(@RequestBody Character character) {
        characterService.update(character);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Event methods
    @GetMapping("events")
    public List<Event> getEvents() {
        return eventService.get();
    }

    @GetMapping("event/{id}")
    public Event getEvent(@PathVariable long id) {
        return eventService.getById(id);
    }

    @PostMapping("addevent")
    public void addEvent(@RequestBody Event event) {
        eventService.add(event);
    }

    @PostMapping("deleteevent")
    public void deleteEvent(@RequestBody Event event) {
        eventService.delete(event);
    }

    @PostMapping("updateevent")
    public void updateEvent(@RequestBody Event event) {
        eventService.update(event);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Character methods
    @GetMapping("eventdetails")
    public List<EventDetail> getEventDetails() {
        return eventDetailService.get();
    }

    @GetMapping("eventdetail/{id}")
    public EventDetail getEventDetail(@PathVariable long id) {
        return eventDetailService.getById(id);
    }

    @PostMapping("addeventdetail")
    public void addEventDetail(@RequestBody EventDetail eventDetail) {
        eventDetailService.add(eventDetail);
    }

    @PostMapping("deleteeventdetail")
    public void deleteEventDetail(@RequestBody EventDetail eventDetail) {
        eventDetailService.delete(eventDetail);
    }

    @PostMapping("updateeventdetail")
    public void updateEventDetail(@RequestBody EventDetail eventDetail) {
        eventDetailService.update(eventDetail);
    }
}
