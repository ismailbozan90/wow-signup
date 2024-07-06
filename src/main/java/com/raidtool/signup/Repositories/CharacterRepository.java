package com.raidtool.signup.Repositories;

import com.raidtool.signup.Entities.Character;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CharacterRepository implements IRepository<Character> {

    private EntityManager entityManager;

    @Autowired
    public CharacterRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Character> get() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Character").getResultList();
    }

    @Override
    public Character getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Character.class, id);
    }

    @Override
    public void add(Character character) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(character);
    }

    @Override
    public void update(Character character) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(character);
    }

    @Override
    public void delete(Character character) {
        Session session = entityManager.unwrap(Session.class);
        Character characterToDelete = session.get(Character.class, character.getId());
        session.delete(characterToDelete);
    }
}
