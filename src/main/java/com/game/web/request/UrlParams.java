package com.game.web.request;

import com.game.entity.enums.Profession;
import com.game.entity.enums.Race;
import com.game.web.PlayerOrder;
import lombok.Data;

@Data
public class UrlParams {

    String name;

    String title;

    Race race;

    Profession profession;

    Long after;

    Long before;

    Boolean banned;

    Integer minExperience;

    Integer maxExperience;

    Integer minLevel;

    Integer maxLevel;

    Integer pageNumber = 0;

    Integer pageSize = 3;

    PlayerOrder playerOrder;

}
