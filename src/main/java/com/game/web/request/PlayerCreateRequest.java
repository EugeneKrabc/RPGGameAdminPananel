package com.game.web.request;

import com.game.entity.enums.Profession;
import com.game.entity.enums.Race;

import lombok.Data;

import javax.validation.constraints.*;


@Data
public class PlayerCreateRequest {

    @NotEmpty
    @Size(max = 12)
    String name;

    @NotEmpty
    @Size(max = 30)
    String title;

    @NotNull
    Race race;

    @NotNull
    Profession profession;

    @NotNull
    @Min(0)
    Long birthday;

    Boolean banned = false;

    @NotNull
    Integer experience;
}
