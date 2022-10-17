package com.game.web.response;

import com.game.entity.enums.Profession;
import com.game.entity.enums.Race;
import lombok.Data;

import java.util.Date;


@Data
public class PlayerResponse {
    private long id;

    String name;

    String title;

    Race race;

    Profession profession;

    Date birthday;

    int experience;

    int level;

    int untilNextLevel;

    boolean banned;
}
