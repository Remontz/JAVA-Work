package com.kacygilbert.languages.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kacygilbert.languages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
	ArrayList<Language> findAll();
	
}
