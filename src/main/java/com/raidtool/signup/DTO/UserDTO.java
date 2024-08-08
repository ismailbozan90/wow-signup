package com.raidtool.signup.DTO;

import com.raidtool.signup.Entities.Character;
import com.raidtool.signup.Entities.EventDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String username;
    private List<Character> characterList;
    private List<EventDetail> eventDetailList;

}
