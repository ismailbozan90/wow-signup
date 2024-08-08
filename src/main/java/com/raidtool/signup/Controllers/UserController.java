package com.raidtool.signup.Controllers;


import com.raidtool.signup.DTO.CharacterDTO;
import com.raidtool.signup.DTO.EventDetailDTO;
import com.raidtool.signup.DTO.UserDTO;
import com.raidtool.signup.Entities.User;
import com.raidtool.signup.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("login")
    public ResponseEntity<Boolean> login(@RequestBody User user) {
        Boolean result = userService.login(user);
        if (!result) {
            return new ResponseEntity<>(false, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("user-characters/{id}")
    public ResponseEntity<List<CharacterDTO>> getUserCharacterList(@PathVariable Long id) {
        List<CharacterDTO> list = userService.getCharacterList(id);
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("user-event-details/{id}")
    public ResponseEntity<List<EventDetailDTO>> getUserEventDetailList(@PathVariable Long id) {
        List<EventDetailDTO> list = userService.getEventDetailList(id);
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // User methods
    @GetMapping("users")
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> list = userService.getUsers();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("users/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        Optional<UserDTO> user = userService.getById(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping("users")
    public ResponseEntity<Boolean> addUser(@RequestBody User user) {
        Boolean result = userService.addUser(user);
        if (!result) {
            return new ResponseEntity<>(false, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
        Boolean result = userService.deleteUser(id);
        if (!result) {
            return new ResponseEntity<>(false, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PutMapping("users")
    public ResponseEntity<Boolean> updateUser(@RequestBody User user) {
        Boolean result = userService.updateUser(user);
        if (!result) {
            return new ResponseEntity<>(false, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


}
