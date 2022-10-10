package com.game.web.response;

import com.game.entity.enums.Profession;
import com.game.entity.enums.Race;
import lombok.Data;


@Data
public class PlayerResponse {
    private long id;

    String name;

    String title;

    Race race;

    Profession profession;

    int experience;

    int level;

    int untilNextLevel;

    boolean banned;
}
