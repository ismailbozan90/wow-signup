package com.raidtool.signup.RestApi;

import com.raidtool.signup.Entities.Characters;
import com.raidtool.signup.Entities.EventDetails;
import com.raidtool.signup.Entities.Events;
import com.raidtool.signup.Entities.User;
import com.raidtool.signup.Service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    IService iService;

    @Autowired
    public Controller(IService iService) {
        this.iService = iService;
    }


    // User Methods
    @GetMapping("/users")
    public List<User> getUsers() {
        return iService.get();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id){
        return (User) iService.getById(id);
    }

    @PostMapping("adduser")
    public void addUser(@RequestBody User user) {
        iService.add(user);
    }

    @PostMapping("deleteuser")
    public void deleteUser(@RequestBody User user) {
        iService.delete(user);
    }

    @PostMapping("updateuser")
    public void updateUser(@RequestBody User user) {
        iService.update(user);
    }

    // Characters Methods
    @GetMapping("/characters")
    public List<Characters> getCharacters() {
        return iService.get();
    }

    @GetMapping("/character/{id}")
    public Characters getCharacterById(@PathVariable int id){
        return (Characters) iService.getById(id);
    }

    @PostMapping("addcharacter")
    public void addCharacter(@RequestBody Characters character) {
        iService.add(character);
    }

    @PostMapping("deletecharacter")
    public void deleteCharacter(@RequestBody Characters character) {
        iService.delete(character);
    }

    @PostMapping("updatecharacter")
    public void updateCharacter(@RequestBody Characters character) {
        iService.update(character);
    }


    // Event Methods
    @GetMapping("/events")
    public List<Events> getEvents() {
        return iService.get();
    }

    @GetMapping("/event/{id}")
    public Events getEventById(@PathVariable int id){
        return (Events) iService.getById(id);
    }

    @PostMapping("addevent")
    public void addEvent(@RequestBody Events events) {
        iService.add(events);
    }

    @PostMapping("deleteevent")
    public void deleteEvent(@RequestBody Events events) {
        iService.delete(events);
    }

    @PostMapping("updateevent")
    public void updateEvent(@RequestBody Events events) {
        iService.update(events);
    }


    // EventDetails Methods
    @GetMapping("/eventdetails")
    public List<EventDetails> getEventDetails() {
        return iService.get();
    }

    @GetMapping("/eventdetail/{id}")
    public EventDetails getEventDetailsById(@PathVariable int id){
        return (EventDetails) iService.getById(id);
    }

    @PostMapping("addeventdetails")
    public void addEventDetail(@RequestBody EventDetails eventDetails) {
        iService.add(eventDetails);
    }

    @PostMapping("deleteeventdetails")
    public void deleteEventDetails(@RequestBody EventDetails eventDetails) {
        iService.delete(eventDetails);
    }

    @PostMapping("updateeventdetails")
    public void updateEvent(@RequestBody EventDetails eventDetails) {
        iService.update(eventDetails);
    }

}
