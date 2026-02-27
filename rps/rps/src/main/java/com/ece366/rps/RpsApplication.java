package com.ece366.rps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@RestController
public class RpsApplication {

	public static void main(String[] args) {
		System.out.println("Starting up service...");
		SpringApplication.run(RpsApplication.class, args);
	}

	// Sample hello world API
	@GetMapping("/helloClass")
	public String helloClass() {
		System.out.println("HELLO");
		return "Hello Class";
	}

	@GetMapping("/getPlayerById/{id}")
	public Player getPlayerById(@PathVariable("id") String id) {
		System.out.println(id);
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"rps", "postgres", "password");
		Player player = new Player();
		try {
			Connection connection = dcm.getConnection();
			PlayerDAO playerDAO = new PlayerDAO(connection);
			player = playerDAO.findById(id);
			System.out.println(player);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return player;
	}

	@PostMapping("/createNewPlayer")
	public Player createNewPlayer(@RequestBody String json) {
		System.out.println(json);
		ObjectMapper objectMapper = new ObjectMapper();
		Player inputPlayer;
		try {
			inputPlayer = objectMapper.readValue(json, Player.class);
		}
		catch (JsonProcessingException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid JSON payload", e);
		}

		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"rps", "postgres", "password");
		Player player = new Player();
		try {
			Connection connection = dcm.getConnection();
			PlayerDAO playerDAO = new PlayerDAO(connection);
			player = playerDAO.create(inputPlayer);
			System.out.println(player);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return player;
	}


	@PostMapping("/deletePlayer")
	public Player deletePlayer(@RequestBody String playerName) {
		System.out.println(playerName);

		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"rps", "postgres", "password");
		Player player = new Player();
		player.setUserName(playerName);
		try {
			Connection connection = dcm.getConnection();
			PlayerDAO playerDAO = new PlayerDAO(connection);
			player = playerDAO.delete(player);
			System.out.println(player);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return player;
	}
}
