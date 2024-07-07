package com.raidtool.signup.Services;

import com.raidtool.signup.Entities.Character;
import com.raidtool.signup.Entities.EventDetail;
import com.raidtool.signup.Entities.User;
import com.raidtool.signup.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IService<User> {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> get() {
        return userRepository.get();
    }

    @Override
    public User getById(long id) {
        return userRepository.getById(id);
    }

    @Override
    public void add(User user) {
        userRepository.add(user);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    public boolean login(User user) {
        return userRepository.login(user);
    }

    public List<Character> getCharacterList(long id) {
        return userRepository.getCharacterList(id);
    }

    public List<EventDetail> getEventDetailList(long id) {
        return userRepository.getEventDetailList(id);
    }
}
