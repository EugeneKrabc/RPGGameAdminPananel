package com.game.web.request;

import com.game.entity.enums.Profession;
import com.game.entity.enums.Race;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class PlayerUpdateRequest {

    @Size(max = 12)
    String name;

    @Size(max = 12)
    String title;

    Race race;

    Profession profession;

    Date birthday;

    Boolean banned;

    @Min(0)
    @Max(10000000)
    Integer experience;
}
