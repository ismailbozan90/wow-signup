package com.raidtool.signup.DataAcces;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class HibernateDataAccess<T> implements IDataAccess<T> {

    private EntityManager entityManager;
    private final Class<T> type;

    @Autowired
    public HibernateDataAccess(EntityManager entityManager, @Autowired Class<T> type) {
        this.entityManager = entityManager;
        this.type = type;
    }

    @Override
    public List<T> get() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from " + type.getName(), type).getResultList();
    }

    @Override
    public T getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(this.type, id);
    }

    @Override
    public void add(T t) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(t);
    }

    @Override
    public void update(T t) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(t);
    }

    @Override
    public void delete(T t) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(t);
    }
}
