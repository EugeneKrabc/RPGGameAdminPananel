package com.game.web.response;

import com.game.entity.enums.Profession;
import com.game.entity.enums.Race;
import lombok.Data;

import java.util.Date;


@Data
public class PlayerResponse {
    Long id;

    String name;

    String title;

    Race race;

    Profession profession;

    Date birthday;

    Integer experience;

    Integer level;

    Integer untilNextLevel;

    Boolean banned;
}
