package com.kacygilbert.teams.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kacygilbert.teams.models.Team;
import com.kacygilbert.teams.repositories.TeamRepository;

@Service
public class TeamService {
	@Autowired
	private TeamRepository teamRepo;
	
	public List<Team> allTeams() {
		return teamRepo.findAll();
	}
	
	public Team createTeam(Team newTeam) {
		return teamRepo.save(newTeam);
	}
	
	public Team getTeamById(Long id) {
		Optional<Team> optionalTeam = teamRepo.findById(id);
		if(optionalTeam.isPresent()) {
			return optionalTeam.get();
		} else {
			return null;
		}
	}
	
	public void updateTeam(Team team) {
		teamRepo.save(team);
	}
	public void deleteTeam(Long id) {
		teamRepo.deleteById(id);
	}
}
