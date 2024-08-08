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
public class EventDetailRepository {

    private final EntityManager entityManager;

    @Autowired
    public EventDetailRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<EventDetail> getEventDetails() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from EventDetail e ORDER BY e.eventId", EventDetail.class).getResultList();
    }

    public EventDetail getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(EventDetail.class, id);
    }

    public Boolean addEventDetail(EventDetail eventDetail) {
        Session session = entityManager.unwrap(Session.class);
        try {
            session.persist(eventDetail);
            return true;
        } catch (Exception e) {
            System.out.println("Error add eventdetail " + e.getMessage());
            return false;
        }

    }

    public Boolean updateEventDetail(EventDetail eventDetail) {
        Session session = entityManager.unwrap(Session.class);
        try {
            EventDetail eventOrigin = session.get(EventDetail.class, eventDetail.getId());
            if (eventOrigin.getSpec() != eventDetail.getSpec() && eventDetail.getStatus() < 3) {
                eventDetail.setStatus(eventDetail.getSpec());
            }
            session.merge(eventDetail);
            return true;
        } catch (Exception e) {
            System.out.println("Error update event_detail " + e.getMessage());
            return false;
        }

    }

    public Boolean deleteEventDetail(Long id) {
        Session session = entityManager.unwrap(Session.class);
        try {
            EventDetail eventDetailToDelete = session.get(EventDetail.class, id);
            session.remove(eventDetailToDelete);
            return true;
        } catch (Exception e) {
            System.out.println("Error delete event_detail " + e.getMessage());
            return false;
        }

    }
}
