package com.raidtool.signup.Entities;


import jakarta.persistence.*;

@Entity
@Table(name = "characters")
public class Character {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "charactername")
    private String characterName;

    @Column(name = "class")
    private String className;


    public Character(long id, long userId, String characterName, String className) {
        this.id = id;
        this.userId = userId;
        this.characterName = characterName;
        this.className = className;
    }

    public Character() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
