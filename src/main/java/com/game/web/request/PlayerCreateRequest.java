package com.game.web.request;

import com.game.entity.enums.Profession;
import com.game.entity.enums.Race;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


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
    Long birthday;

    Boolean banned = false;

    @NotNull
    Integer experience;
}
