package com.kacygilbert.mvcbakery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kacygilbert.mvcbakery.models.Chef;
import com.kacygilbert.mvcbakery.repositories.ChefRepository;

@Service
public class ChefService {
	private final ChefRepository chefRepo;
	
	public ChefService(ChefRepository chefRepo) {
		this.chefRepo = chefRepo;
	}
	
	// Levers to be used. 
	public List<Chef> allChefs() {
		return chefRepo.findAll();
	}
	
	public Chef findById(Long id) {
		Optional<Chef> optChef = chefRepo.findById(id);
		if(optChef.isPresent()) {
			return optChef.get();
		} else {
			return null;
		}
	}
	
}
