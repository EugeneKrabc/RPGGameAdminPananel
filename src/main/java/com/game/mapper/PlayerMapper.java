package com.game.mapper;

import com.game.entity.Player;
import com.game.web.response.PlayerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper {
    PlayerResponse playerToPlayerResponse(Player player);
}
