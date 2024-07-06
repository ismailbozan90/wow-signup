package com.raidtool.signup.Services;

import com.raidtool.signup.Entities.Character;
import com.raidtool.signup.Repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService implements IService<Character> {

    CharacterRepository characterRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<Character> get() {
        return characterRepository.get();
    }

    @Override
    public Character getById(int id) {
        return characterRepository.getById(id);
    }

    @Override
    public void add(Character character) {
        characterRepository.add(character);
    }

    @Override
    public void update(Character character) {
        characterRepository.update(character);
    }

    @Override
    public void delete(Character character) {
        characterRepository.delete(character);
    }
}
