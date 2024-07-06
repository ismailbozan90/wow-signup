package com.raidtool.signup.Entities;


import jakarta.persistence.*;
import jdk.jfr.Event;

import java.util.Date;

@Entity
@Table(name="events")
public class Events {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="enddate")
    private Date endDate;


    public Events(int id, String title, String description, Date endDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.endDate = endDate;
    }

    public Events() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
