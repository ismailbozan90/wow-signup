package com.raidtool.signup.Repositories;

import com.raidtool.signup.Entities.Character;
import com.raidtool.signup.Entities.EventDetail;
import com.raidtool.signup.Entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserRepository implements IRepository<User> {

    private EntityManager entityManager;

    @Autowired
    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> get() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from User").getResultList();
    }

    @Override
    public User getById(long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(User.class, id);
    }

    @Override
    public void add(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
    }

    @Override
    public void update(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
    }

    @Override
    public void delete(User user) {
        Session session = entityManager.unwrap(Session.class);
        User userToDelete = session.get(User.class, user.getId());
        session.delete(userToDelete);
    }

    public boolean login(User user) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "FROM User u WHERE u.username = :username AND u.password = :password";
        Query query = session.createQuery(hql);
        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());
        List<User> result = query.getResultList();
        return !result.isEmpty();
    }

    public List<Character> getCharacterList(long id) {
        Session session = entityManager.unwrap(Session.class);
        User findUser = session.get(User.class, id);
        return findUser.getCharacterList();
    }

    public List<EventDetail> getEventDetailList(long id) {
        Session session = entityManager.unwrap(Session.class);
        User findUser = session.get(User.class, id);
        return findUser.getEventDetailList();
    }
}
