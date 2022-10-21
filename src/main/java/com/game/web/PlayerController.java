package com.game.web;

import com.game.entity.enums.Profession;
import com.game.entity.enums.Race;
import com.game.mapper.PlayerMapper;
import com.game.service.PlayerService;
import com.game.web.request.PlayerCreateRequest;
import com.game.web.request.UrlParams;
import com.game.web.response.PlayerResponse;


import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Slf4j
@RestController
@Validated
@RequestMapping(value = "/rest/players")
public class PlayerController {

    private static final Logger LOGGER = Logger.getLogger("Logger");

    private final PlayerService playerService;

    private final PlayerMapper playerMapper;

    public PlayerController(PlayerService playerService, PlayerMapper playerMapper) {
        this.playerService = playerService;
        this.playerMapper = playerMapper;
    }

    @GetMapping
    public List<PlayerResponse> getPlayersList(UrlParams urlParams) {
        LOGGER.log(Level.INFO,"Receive Get player list request, URL Params: " + urlParams.toString());

        return playerService.getAllPlayers(urlParams).stream()
                .map(playerMapper::playerToPlayerResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/count")
    public long getPlayersCount(UrlParams urlParams) {
        return playerService.getPlayersCount(urlParams);
    }

    @GetMapping("/{id}")
    public PlayerResponse getPlayerById(@PathVariable long id) {
        return mockPlayer();
    }

    @PostMapping
    public PlayerResponse createPlayer(@RequestBody @Validated PlayerCreateRequest playerCreateRequest) {
        LOGGER.log(Level.INFO, "Receive playerCreateRequest: " + playerCreateRequest);
        return mockPlayer();
    }

    @PutMapping({"/id"})
    public PlayerResponse updatePlayer(@PathVariable long id) {
        return mockPlayer();
    }

    private Comparator<PlayerResponse>  idComparator = (p1, p2) -> 0;

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
