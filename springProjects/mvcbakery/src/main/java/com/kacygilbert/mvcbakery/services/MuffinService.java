package com.kacygilbert.mvcbakery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kacygilbert.mvcbakery.models.Muffin;
import com.kacygilbert.mvcbakery.repositories.MuffinRepository;

@Service
public class MuffinService {
// In the crane example the crane is JPA, the repository is the levers and the service is the person operating the levers.
	//we need to allow it to talk to the book repository
	private final MuffinRepository muffinRepo;
	
	public MuffinService(MuffinRepository muffinRepo) {
		this.muffinRepo = muffinRepo;
	} //gives us access to the repository...
	
	public List<Muffin> allMuffins() {
		return muffinRepo.findAll();
	}
	
	public Muffin createMuffin(Muffin newMuffin) {
		return muffinRepo.save(newMuffin);
	}
	
	public Muffin findMuffinById(Long id) {
		Optional<Muffin> optionalMuffin = muffinRepo.findById(id);
		if(optionalMuffin.isPresent()) {
			return optionalMuffin.get();
		} else {
			return null;
		}
	}
	
	public void updateMuffin(Muffin muffin) {
		muffinRepo.save(muffin);
	}
	
	public void deleteMuffin(Long id) {
		muffinRepo.deleteById(id);
	}
}
