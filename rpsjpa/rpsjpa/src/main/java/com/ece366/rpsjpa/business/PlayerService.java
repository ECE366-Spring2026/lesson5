package com.ece366.rpsjpa.business;

import com.ece366.rpsjpa.data.Player;
import com.ece366.rpsjpa.data.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers(){
        Iterable<Player> players = this.playerRepository.findAll();
        List<Player> playerList = new ArrayList<>();
        players.forEach(player->{playerList.add(player);});
        return playerList;
    }

    public String createPlayer(String userName, String password) {
        Player p = new Player();
        p.setUserName(userName);
        p.setPassword(password);
        this.playerRepository.save(p);
        return "CREATED " + userName;
    }

    public String deletePlayer(String userName) {
        Player p = new Player();
        p.setUserName(userName);
        this.playerRepository.delete(p);
        return "DELETED " + userName;
    }
}
