package com.game.service.impl;

import com.game.entity.Player;
import com.game.repository.PlayerRepository;
import com.game.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public long getPlayersCount() {
        return playerRepository.count();
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
}
