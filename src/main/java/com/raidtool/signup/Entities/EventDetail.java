package com.raidtool.signup.Entities;


import jakarta.persistence.*;

@Entity
@Table(name="eventdetails")
public class EventDetail {


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

    @Column(name="user_id")
    private int userId;


    public EventDetail(int id, int eventId, String characterName, int status, int userId) {
        this.id = id;
        this.eventId = eventId;
        this.characterName = characterName;
        this.status = status;
        this.userId = userId;
    }

    public EventDetail() {}

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int id) {
        this.userId = id;
    }
}
