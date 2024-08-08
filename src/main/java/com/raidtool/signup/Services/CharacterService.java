package com.raidtool.signup.Services;

import com.raidtool.signup.DTO.CharacterDTO;
import com.raidtool.signup.Entities.Character;
import com.raidtool.signup.Repositories.CharacterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CharacterService(CharacterRepository characterRepository, ModelMapper modelMapper) {
        this.characterRepository = characterRepository;
        this.modelMapper = modelMapper;
    }

    public List<CharacterDTO> getCharacters() {
        List<Character> characterList = characterRepository.getCharacters();
        return characterList.stream().map(character -> modelMapper.map(character, CharacterDTO.class)).toList();
    }

    public Optional<CharacterDTO> getById(Long id) {
        Character character = characterRepository.getById(id);
        if (character == null) {
            return Optional.empty();
        }
        return Optional.of(modelMapper.map(character, CharacterDTO.class));
    }

    public Boolean addCharacter(Character character) {
        return characterRepository.addCharacter(character);
    }

    public Boolean updateCharacter(Character character) {
        return characterRepository.updateCharacter(character);
    }

    public Boolean deleteCharacter(Long id) {
        return characterRepository.deleteCharacter(id);
    }
}
