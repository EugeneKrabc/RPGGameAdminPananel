package com.game.service.impl;

import com.game.entity.Player;
import com.game.repository.PlayerRepository;
import com.game.service.PlayerService;
import com.game.web.PlayerOrder;
import com.game.web.request.UrlParams;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public long getPlayersCount(UrlParams urlParams) {
        return findAndFilterPlayers(urlParams).count();
    }

    @Override
    public List<Player> getAllPlayers(UrlParams urlParams) {
        return findAndFilterPlayers(urlParams)
                .sorted((p1, p2) -> {
                    if (urlParams.getOrder() == PlayerOrder.NAME) {
                        return String.CASE_INSENSITIVE_ORDER.compare(p1.getName(), p2.getName());
                    } else if (urlParams.getOrder() == PlayerOrder.EXPERIENCE) {
                        return Long.compare(p1.getExperience(), p2.getExperience());
                    } else if (urlParams.getOrder() == PlayerOrder.BIRTHDAY) {
                        return (p1.getBirthday().compareTo(p2.getBirthday()));
                    } else {
                        return Long.compare(p1.getId(), p2.getId());
                    }
                })
                .skip((long) urlParams.getPageSize() * urlParams.getPageNumber())
                .limit(urlParams.getPageSize())
                .collect(Collectors.toList());
    }

    @Override
    public Player createPlayer(Player player) {
        int exp = player.getExperience();
        int level = (int)(Math.sqrt(2500 + 200 * exp) - 50) / 100;
        int untilNextLevel = 50 * (level + 1) * (level + 2) - exp;

        player.setLevel(level);
        player.setUntilNextLevel(untilNextLevel);
        return playerRepository.save(player);
    }

    private Stream<Player> findAndFilterPlayers(UrlParams urlParams) {
        return playerRepository.findAll().stream()
                .filter(player -> {
                    boolean isCorresponds = true;
                    if (urlParams.getName() != null) {
                        isCorresponds = player.getName().contains(urlParams.getName());
                    }
                    if (isCorresponds && urlParams.getTitle() != null) {
                        isCorresponds = player.getTitle().contains(urlParams.getTitle());
                    }
                    if (isCorresponds && urlParams.getRace() != null) {
                        isCorresponds = player.getRace().equals(urlParams.getRace());
                    }
                    if (isCorresponds && urlParams.getProfession() != null) {
                        isCorresponds = player.getProfession().equals(urlParams.getProfession());
                    }
                    if (isCorresponds && urlParams.getAfter() != null) {
                        isCorresponds = player.getBirthday().getTime() > urlParams.getAfter();
                    }
                    if (isCorresponds && urlParams.getBefore() != null) {
                        isCorresponds = player.getBirthday().getTime() < urlParams.getBefore();
                    }
                    if (isCorresponds && urlParams.getBanned() != null) {
                        isCorresponds = urlParams.getBanned() == player.isBanned();
                    }
                    if (isCorresponds && urlParams.getMinExperience() != null) {
                        isCorresponds = player.getExperience() >= urlParams.getMinExperience();
                    }
                    if (isCorresponds && urlParams.getMaxExperience() != null) {
                        isCorresponds = player.getExperience() <= urlParams.getMaxExperience();
                    }
                    if (isCorresponds && urlParams.getMinLevel() != null) {
                        isCorresponds = player.getLevel() >= urlParams.getMinLevel();
                    }
                    if (isCorresponds && urlParams.getMaxLevel() != null) {
                        isCorresponds = player.getLevel() <= urlParams.getMaxLevel();
                    }
                    return  isCorresponds;
                });
    }
}
