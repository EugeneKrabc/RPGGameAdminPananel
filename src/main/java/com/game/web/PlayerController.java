package com.game.web;

import com.game.entity.enums.Profession;
import com.game.entity.enums.Race;
import com.game.mapper.PlayerMapper;
import com.game.service.PlayerService;
import com.game.web.request.UrlParams;
import com.game.web.response.PlayerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(value = "/rest/players")
public class PlayerController {

    private final PlayerService playerService;

    private final PlayerMapper playerMapper;

    public PlayerController(PlayerService playerService, PlayerMapper playerMapper) {
        this.playerService = playerService;
        this.playerMapper = playerMapper;
    }

    @GetMapping
    public List<PlayerResponse> getPlayersList(UrlParams urlParams) {
        log.info("Get layer receive urlParams: {}", urlParams);

        return playerService.getAllPlayers().stream()
                .map(playerMapper::playerToPlayerResponse)
                .skip((long) urlParams.getPageSize() * urlParams.getPageNumber())
                .limit(urlParams.getPageSize())
                .collect(Collectors.toList());
    }

    @GetMapping("/count")
    public long getPlayersCount() {
        return playerService.getPlayersCount();
    }

    @GetMapping("/{id}")
    public PlayerResponse getPlayerById(@PathVariable long id) {
        return mockPlayer();
    }

    @PostMapping
    public PlayerResponse createPlayer() {
        return mockPlayer();
    }

    @PutMapping({"/id"})
    public PlayerResponse updatePlayer(@PathVariable long id) {
        return mockPlayer();
    }



    private PlayerResponse mockPlayer() {
        PlayerResponse mock = new PlayerResponse();
        mock.setId(123);
        mock.setName("some name");
        mock.setTitle("Some title");
        mock.setRace(Race.HUMAN);
        mock.setProfession(Profession.WARLOCK);
        mock.setExperience(12345);
        mock.setLevel(3);
        mock.setUntilNextLevel(123);
        mock.setBanned(false);
        return mock;
    }
}
