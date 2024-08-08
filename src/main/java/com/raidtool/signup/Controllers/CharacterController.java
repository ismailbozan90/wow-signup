package com.raidtool.signup.Controllers;


import com.raidtool.signup.DTO.CharacterDTO;
import com.raidtool.signup.Entities.Character;
import com.raidtool.signup.Services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Character methods
    @GetMapping("characters")
    public ResponseEntity<List<CharacterDTO>> getCharacters() {
        List<CharacterDTO> list = characterService.getCharacters();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("characters/{id}")
    public ResponseEntity<CharacterDTO> getCharacter(@PathVariable Long id) {
        Optional<CharacterDTO> findCharacter = characterService.getById(id);
        return findCharacter.map(character -> new ResponseEntity<>(character, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("characters")
    public ResponseEntity<Boolean> addCharacter(@RequestBody Character character) {
        Boolean result = characterService.addCharacter(character);
        if (!result) {
            return new ResponseEntity<>(false,HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }

    @DeleteMapping("characters/{id}")
    public ResponseEntity<Boolean> deleteCharacter(@PathVariable Long id) {
        Boolean result = characterService.deleteCharacter(id);
        if (!result) {
            return new ResponseEntity<>(false, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PutMapping("characters")
    public ResponseEntity<Boolean> updateCharacter(@RequestBody Character character) {
        Boolean result = characterService.updateCharacter(character);
        if (!result) {
            return new ResponseEntity<>(false, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);

    }


}
