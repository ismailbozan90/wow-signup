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
public class CharacterRepository {

    private final EntityManager entityManager;

    @Autowired
    public CharacterRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Character> getCharacters() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Character", Character.class).getResultList();
    }

    public Character getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Character.class, id);
    }

    public Boolean addCharacter(Character character) {
        Session session = entityManager.unwrap(Session.class);
        try {
            session.persist(character);
            return true;
        } catch (Exception e) {
            System.out.println("Error add character : " + e.getMessage());
            return false;
        }
    }

    public Boolean updateCharacter(Character character) {
        Session session = entityManager.unwrap(Session.class);
        try {
            session.merge(character);
            return true;
        } catch (Exception e) {
            System.out.println("Error update character : " + e.getMessage());
            return false;
        }
    }

    public Boolean deleteCharacter(Long id) {
        Session session = entityManager.unwrap(Session.class);
        try {
            Character characterToDelete = session.get(Character.class, id);
            session.remove(characterToDelete);
            return true;
        } catch (Exception e) {
            System.out.println("Error delete character : " + e.getMessage());
            return false;
        }
    }
}
