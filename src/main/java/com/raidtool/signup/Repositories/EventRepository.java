package com.raidtool.signup.Repositories;

import com.raidtool.signup.Entities.Event;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EventRepository  {

    private final EntityManager entityManager;

    @Autowired
    public EventRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Event> getEvents() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Event", Event.class).getResultList();
    }

    public Event getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Event.class, id);
    }

    public Boolean addEvent(Event event) {
        Session session = entityManager.unwrap(Session.class);
        try {
            session.persist(event);
            return true;
        } catch (Exception e) {
            System.out.println("Error add event : " + e.getMessage());
            return false;
        }

    }

    public Boolean updateEvent(Event event) {
        Session session = entityManager.unwrap(Session.class);
        try {
            session.merge(event);
            return true;
        } catch (Exception e) {
            System.out.println("Error update event : " + e.getMessage());
            return false;
        }
    }

    public Boolean deleteEvent(Long id) {
        Session session = entityManager.unwrap(Session.class);
        try {
            Event eventToDelete = session.get(Event.class, id);
            session.remove(eventToDelete);
            return true;
        } catch (Exception e) {
            System.out.println("Error delete event : " + e.getMessage());
            return false;
        }
    }
}
