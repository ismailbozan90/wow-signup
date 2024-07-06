package com.raidtool.signup.DataAcces;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class HibernateDataAccess<T> implements IDataAccess<T> {

    @PersistenceContext
    private EntityManager entityManager;

    private final Class<T> type;

    public HibernateDataAccess(Class<T> type) {
        this.type = type;
    }

    @Override
    public List<T> get() {
        return List.of();
    }

    @Override
    public T getById(int id) {
        return null;
    }

    @Override
    public void add(T t) {

    }

    @Override
    public void update(T t) {

    }

    @Override
    public void delete(T t) {

    }
}
