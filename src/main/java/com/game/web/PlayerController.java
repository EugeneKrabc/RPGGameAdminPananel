package com.game.web;

import com.game.entity.enums.Profession;
import com.game.entity.enums.Race;
import com.game.mapper.PlayerMapper;
import com.game.service.PlayerService;
import com.game.web.request.PlayerCreateRequest;
import com.game.web.request.PlayerUpdateRequest;
import com.game.web.request.UrlParams;
import com.game.web.response.PlayerResponse;


import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
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
        LOGGER.log(Level.INFO, "Receive get player count request: " + urlParams);
        return playerService.getPlayersCount(urlParams);
    }

    @GetMapping("/{id}")
    public PlayerResponse getPlayerById(@PathVariable @Min(1) long id) {
        LOGGER.log(Level.INFO, "Receive get player by id request, id = " + id);
        return playerMapper.playerToPlayerResponse(playerService.getPlayerById(id));
    }

    @PostMapping
    public PlayerResponse createPlayer(@RequestBody @Validated PlayerCreateRequest playerCreateRequest) {
        LOGGER.log(Level.INFO, "Receive player create request: " + playerCreateRequest);
        return playerMapper.playerToPlayerResponse(
                playerService.createPlayer(playerMapper.playerCreateRequestToPlayer(playerCreateRequest)));
    }

    @PutMapping("/{id}")
    public PlayerResponse updatePlayer(@PathVariable @Min(1) Long id,
                                       @RequestBody @Valid PlayerUpdateRequest playerUpdateRequest) {
        LOGGER.log(Level.INFO, "Receive player update request: " + playerUpdateRequest);
        return playerMapper.playerToPlayerResponse(
                playerService.updatePlayer(id, playerMapper.playerUpdateRequestToPlayer(playerUpdateRequest)));
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable @Min(1) Long id) {
        LOGGER.log(Level.INFO, "Receive delete player request: " + id);
        playerService.deletePlayer(id);
    }

}
