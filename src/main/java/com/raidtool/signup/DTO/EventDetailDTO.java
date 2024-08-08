package com.raidtool.signup.DTO;

import com.raidtool.signup.Entities.Character;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDetailDTO {

    private int status;
    private int spec;
    private List<Character> character;

}
