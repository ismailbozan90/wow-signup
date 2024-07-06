package com.raidtool.signup.Repositories;

import com.raidtool.signup.Entities.EventDetail;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EventDetailRepository implements IRepository<EventDetail> {

    private EntityManager entityManager;

    @Autowired
    public EventDetailRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<EventDetail> get() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from EventDetail").getResultList();
    }

    @Override
    public EventDetail getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(EventDetail.class, id);
    }

    @Override
    public void add(EventDetail eventDetail) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(eventDetail);
    }

    @Override
    public void update(EventDetail eventDetail) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(eventDetail);
    }

    @Override
    public void delete(EventDetail eventDetail) {
        Session session = entityManager.unwrap(Session.class);
        EventDetail eventDetailToDelete = session.get(EventDetail.class, eventDetail.getId());
        session.delete(eventDetailToDelete);
    }
}
