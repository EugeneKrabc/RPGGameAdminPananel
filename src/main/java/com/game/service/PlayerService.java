package com.game.service;


import com.game.entity.Player;

import java.util.List;

public interface PlayerService {
    long getPlayersCount();
    List<Player> getAllPlayers();
}
