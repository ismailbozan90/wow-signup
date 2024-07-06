package com.raidtool.signup.Entities;


import jakarta.persistence.*;

@Entity
@Table(name="eventdetails")
public class EventDetails {


    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="event_id")
    private int eventId;

    @Column(name="character")
    private String characterName;

    @Column(name="status")
    private int status;


    public EventDetails(int id, int eventId, String characterName, int status) {
        this.id = id;
        this.eventId = eventId;
        this.characterName = characterName;
        this.status = status;
    }

    public EventDetails() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
