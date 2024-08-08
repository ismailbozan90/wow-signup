package com.raidtool.signup.Services;

import com.raidtool.signup.DTO.CharacterDTO;
import com.raidtool.signup.DTO.EventDetailDTO;
import com.raidtool.signup.DTO.UserDTO;
import com.raidtool.signup.Entities.Character;
import com.raidtool.signup.Entities.EventDetail;
import com.raidtool.signup.Entities.User;
import com.raidtool.signup.Repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<UserDTO> getUsers() {
        List<User> userList = userRepository.getUsers();
        return userList.stream().map(user -> modelMapper.map(user, UserDTO.class)).toList();
    }

    public Optional<UserDTO> getById(Long id) {
        User user = userRepository.getById(id);
        if (user == null) {
            return Optional.empty();
        }
        return Optional.of(modelMapper.map(user, UserDTO.class));
    }

    public Boolean addUser(User user) {
        return userRepository.addUser(user);
    }

    public Boolean updateUser(User user) {
        return userRepository.updateUser(user);
    }

    public Boolean deleteUser(Long id) {
        return userRepository.deleteUser(id);
    }

    public Boolean login(User user) {
        return userRepository.login(user);
    }

    public List<CharacterDTO> getCharacterList(Long id) {
        List<Character> characterList = userRepository.getCharacterList(id);
        return characterList.stream().map(character -> modelMapper.map(character, CharacterDTO.class)).toList();
    }

    public List<EventDetailDTO> getEventDetailList(Long id) {
        List<EventDetail> eventDetailList = userRepository.getEventDetailList(id);
        return eventDetailList.stream().map(eventDetail -> modelMapper.map(eventDetail, EventDetailDTO.class)).toList();
    }
}
