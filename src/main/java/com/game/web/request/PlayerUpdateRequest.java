package com.game.web.request;

import com.game.entity.enums.Profession;
import com.game.entity.enums.Race;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class PlayerUpdateRequest {

    @NotEmpty
    @Size(max = 12)
    String name;

    @NotEmpty
    @Size(max = 12)
    String title;

    Race race;

    Profession profession;

    Date birthday;

    Boolean banned;

    Integer experience;
}
