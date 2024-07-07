package com.raidtool.signup.Entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "eventdetails")
public class EventDetail {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "event_id")
    private long eventId;

    @Column(name = "character_id")
    private long characterId;

    @Column(name = "status")
    private int status;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "spec")
    private int spec;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "character_id")
    private List<Character> character;

    public EventDetail(long id, long eventId, long characterId, int status, long userId) {
        this.id = id;
        this.eventId = eventId;
        this.characterId = characterId;
        this.status = status;
        this.userId = userId;
    }

    public EventDetail() {
    }

    public void setCharacter(List<Character> character) {
        this.character = character;
    }

    public List<Character> getCharacter() {
        return character;
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

    public long getCharacterId() {
        return characterId;
    }

    public void setCharacterId(long characterId) {
        this.characterId = characterId;
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

    public int getSpec() {
        return spec;
    }

    public void setSpec(int spec) {
        this.spec = spec;
    }
}
