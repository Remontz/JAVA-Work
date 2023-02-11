package com.kacygilbert.dojoRoster.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kacygilbert.dojoRoster.models.Dojo;
import com.kacygilbert.dojoRoster.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepo;
	
	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	public ArrayList<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
	public Dojo createDojo(Dojo newDojo) {
		return dojoRepo.save(newDojo);
	}
	
	public Dojo findDojoById(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	
	public void updateDojo(Dojo dojo) {
		dojoRepo.save(dojo);
	}
	
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}
}
