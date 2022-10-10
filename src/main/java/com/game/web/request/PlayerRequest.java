package com.game.web.request;

import com.game.entity.enums.Profession;
import com.game.entity.enums.Race;
import lombok.Data;

@Data
public class PlayerRequest {
    String name;

    String title;

    Race race;

    Profession profession;

    Long birthday;

    Boolean banned;

    Integer experience;
}
