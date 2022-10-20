package com.game.web.request;

import com.game.entity.enums.Profession;
import com.game.entity.enums.Race;

import jakarta.validation.constraints.NotNull;
import lombok.Data;



@Data
public class PlayerCreateRequest {

    String name;

    String title;

    Race race;

    Profession profession;

    @NotNull
    Long birthday;

    Boolean banned = true;

    Integer experience;
}
