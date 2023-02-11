package com.kacygilbert.teams.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kacygilbert.teams.models.Coach;
import com.kacygilbert.teams.repositories.CoachRepository;

@Service
public class CoachService {

	@Autowired
	private CoachRepository coachRepo;
	
	public List<Coach> allCoaches() {
		return coachRepo.findAll();
	}
	
	public Coach createCoach(Coach newCoach) {
		return coachRepo.save(newCoach);
	}
	
	public Coach getCoachById(Long id) {
		Optional<Coach> optionalCoach = coachRepo.findById(id);
		if(optionalCoach.isPresent()) {
			return optionalCoach.get();
		} else {
			return null;
		}
	}
	
	public void updateCoach(Coach coach) {
		coachRepo.save(coach);
	}
	public void deleteCoach(Long id) {
		coachRepo.deleteById(id);
	}
}
