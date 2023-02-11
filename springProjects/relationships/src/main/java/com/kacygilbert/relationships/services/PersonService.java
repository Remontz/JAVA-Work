package com.kacygilbert.relationships.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kacygilbert.relationships.models.Person;
import com.kacygilbert.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepo;
	
	public PersonService(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}
	
	// CREATES a Person
	public Person createPerson(Person newPerson) {
		return personRepo.save(newPerson);
	}
	
	// Returns ALL Person(s) / People
	public ArrayList<Person> allPeople() {
		return personRepo.findAll();
	}
	
	// Retrieve Person by Id
	public Person findById(Long id) {
		Optional<Person> optionalPerson = personRepo.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else {
			return null;
		}
	}
	
	// UPDATES a Person
	public void updatePerson(Person person) {
		personRepo.save(person);
	}
	
	// DELETE a Person by Id
	public void deletePerson(Long id) {
		personRepo.deleteById(id);
	}
}
