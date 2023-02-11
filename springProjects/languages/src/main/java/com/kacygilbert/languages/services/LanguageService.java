package com.kacygilbert.languages.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kacygilbert.languages.models.Language;
import com.kacygilbert.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository langRepo;
	
	public LanguageService(LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}
	
	// returns all languages
	public ArrayList<Language> allLanguages() {
		return langRepo.findAll();
	}
	
	// creates a language
	public Language createLanguage(Language newLanguage) {
		return langRepo.save(newLanguage);
	}
	
	//finds Language by id
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = langRepo.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	
	// updates a Language
	public void updateLanguage(Language language) {
		langRepo.save(language);
	}
	
	// deletes Language
	public void deleteLanguage(Long id) {
		langRepo.deleteById(id);
	}
}
