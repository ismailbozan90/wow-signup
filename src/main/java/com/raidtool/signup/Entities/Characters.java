package com.raidtool.signup.Entities;


import jakarta.persistence.*;

@Entity
@Table(name="characters")
public class Characters {


    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="user_id")
    private int userId;

    @Column(name="charactername")
    private String characterName;

    @Column(name="class")
    private String className;


    public Characters(int id, int userId, String characterName, String className) {
        this.id = id;
        this.userId = userId;
        this.characterName = characterName;
        this.className = className;
    }

    public Characters() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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
