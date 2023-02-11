package com.kacygilbert.dojoRoster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kacygilbert.dojoRoster.models.Ninja;
import com.kacygilbert.dojoRoster.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepo;
	
	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}
	
	public Ninja createNinja(Ninja newNinja) {
		return ninjaRepo.save(newNinja);
	}
	
	public Ninja findNinjaById(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	
	public void updateNinja(Ninja ninja) {
		ninjaRepo.save(ninja);
	}
	
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
}
