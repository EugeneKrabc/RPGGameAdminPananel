package com.game.mapper;

import com.game.entity.Player;
import com.game.web.request.PlayerCreateRequest;
import com.game.web.response.PlayerResponse;
import org.mapstruct.Mapper;

import java.util.Date;

@Mapper(componentModel = "spring")
public interface PlayerMapper {
    PlayerResponse playerToPlayerResponse(Player player);
    Player playerCreateRequestToPlayer(PlayerCreateRequest playerCreateRequest);

    default Date map(Long value) {
        return new Date(value);
    }
}
