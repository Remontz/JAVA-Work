package com.kacygilbert.teams.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kacygilbert.teams.models.Player;
import com.kacygilbert.teams.repositories.PlayerRepository;

@Service
public class PlayerService {
	@Autowired
	private PlayerRepository playerRepo;
	
	public List<Player> allPlayers() {
		return playerRepo.findAll();
	}
	
	public Player createPlayer(Player newPlayer) {
		return playerRepo.save(newPlayer);
	}
	
	public Player getPlayerById(Long id) {
		Optional<Player> optionalPlayer = playerRepo.findById(id);
		if(optionalPlayer.isPresent()) {
			return optionalPlayer.get();
		} else {
			return null;
		}
	}
	
	public void updatePlayer(Player player) {
		playerRepo.save(player);
	}
	public void deletePlayer(Long id) {
		playerRepo.deleteById(id);
	}
}
