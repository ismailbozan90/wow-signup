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
public class EventRepository implements IRepository<Event> {

    private EntityManager entityManager;

    @Autowired
    public EventRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Event> get() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Event").getResultList();
    }

    @Override
    public Event getById(long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Event.class, id);
    }

    @Override
    public void add(Event event) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(event);
    }

    @Override
    public void update(Event event) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(event);
    }

    @Override
    public void delete(Event event) {
        Session session = entityManager.unwrap(Session.class);
        Event eventToDelete = session.get(Event.class, event.getId());
        session.delete(eventToDelete);
    }
}
