package com.game.service;


import com.game.entity.Player;
import com.game.web.request.UrlParams;

import java.util.List;

public interface PlayerService {
    long getPlayersCount(UrlParams urlParams);

    List<Player> getAllPlayers(UrlParams urlParams);

    Player createPlayer(Player player);

    Player getPlayerById(Long id);

    Player updatePlayer(Long id, Player dataToUpdate);

    void deletePlayer(Long id);
}
