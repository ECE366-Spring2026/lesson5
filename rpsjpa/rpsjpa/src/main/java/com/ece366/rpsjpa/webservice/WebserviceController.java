package com.ece366.rpsjpa.webservice;

import com.ece366.rpsjpa.business.PlayerService;
import com.ece366.rpsjpa.data.Player;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import tools.jackson.databind.ObjectMapper;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

@RestController
public class WebserviceController {
    @GetMapping("/testPlayer")
    public String getTestPlayer() {
        return "TEST PLAYER";
    }

    private final PlayerService playerService;

    public WebserviceController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public List<Player> getPlayers(){
        System.out.println("getPlayers");
        return this.playerService.getPlayers();
    }

    @PostMapping("/create")
    public String createPlayer(@RequestBody String json) {
        System.out.println("createPlayer");
        System.out.println(json);
        ObjectMapper objectMapper = new ObjectMapper();
        Player inputPlayer;
        inputPlayer = objectMapper.readValue(json, Player.class);
        return this.playerService.createPlayer(inputPlayer.getUserName(), inputPlayer.getPassword());
    }

    @PostMapping("/delete")
    public String deletePlayer(@RequestBody String userName) {
        System.out.println("deletePlayer");
        return this.playerService.deletePlayer(userName);
    }
}
