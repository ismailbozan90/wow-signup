package com.raidtool.signup.Entities;


import jakarta.persistence.*;

@Entity
@Table(name = "eventdetails")
public class EventDetail {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "event_id")
    private long eventId;

    @Column(name = "character")
    private String characterName;

    @Column(name = "status")
    private int status;

    @Column(name = "user_id")
    private long userId;

    @OneToMany(fetch = FetchType.LAZY)
    private Character character;


    public EventDetail(long id, long eventId, String characterName, int status, long userId) {
        this.id = id;
        this.eventId = eventId;
        this.characterName = characterName;
        this.status = status;
        this.userId = userId;
    }

    public EventDetail() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long id) {
        this.userId = id;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
