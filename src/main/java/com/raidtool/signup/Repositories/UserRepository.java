package com.raidtool.signup.Repositories;

import com.raidtool.signup.Entities.Character;
import com.raidtool.signup.Entities.EventDetail;
import com.raidtool.signup.Entities.User;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserRepository {

    private final EntityManager entityManager;

    @Autowired
    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> getUsers() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from User", User.class).getResultList();
    }

    public User getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(User.class, id);
    }

    public Boolean addUser(User user) {
        Session session = entityManager.unwrap(Session.class);

        try {
            String sql = "INSERT INTO users (user_name, password) VALUES (:username, SHA2(:password, 256))";
            session.createNativeQuery(sql, User.class)
                    .setParameter("username", user.getUsername())
                    .setParameter("password", user.getPassword())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error add user : " + e.getMessage());
            return false;
        }
    }

    public Boolean updateUser(User user) {
        Session session = entityManager.unwrap(Session.class);
        try {
            String sql = "UPDATE users SET user_name=:username, password = SHA2(:password, 256) WHERE id=:id";
            session.createNativeQuery(sql, User.class)
                    .setParameter("username", user.getUsername())
                    .setParameter("password", user.getUsername())
                    .setParameter("id", user.getId())
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error update user : " + e.getMessage());
            return false;
        }
    }

    public Boolean deleteUser(Long id) {
        Session session = entityManager.unwrap(Session.class);
        try {
            User userToDelete = session.get(User.class, id);
            session.remove(userToDelete);
            return true;
        } catch (Exception e) {
            System.out.println("Error delete user : " + e.getMessage());
            return false;
        }
    }

    public Boolean login(User user) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "SELECT * FROM users WHERE user_name = :username AND password = SHA2(:password, 256)";
        return !session.createNativeQuery(sql, User.class)
                .setParameter("username", user.getUsername())
                .setParameter("password", user.getPassword())
                .getResultList().isEmpty();
    }

    public List<Character> getCharacterList(Long id) {
        Session session = entityManager.unwrap(Session.class);
        User findUser = session.get(User.class, id);
        return findUser.getCharacterList();
    }

    public List<EventDetail> getEventDetailList(Long id) {
        Session session = entityManager.unwrap(Session.class);
        User findUser = session.get(User.class, id);
        return findUser.getEventDetailList();
    }
}
