package com.game.service;


import com.game.entity.Player;
import com.game.web.request.UrlParams;

import java.util.List;

public interface PlayerService {
    long getPlayersCount();
    List<Player> getAllPlayers(UrlParams urlParams);
}
