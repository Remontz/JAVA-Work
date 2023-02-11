package com.kacygilbert.relationships.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kacygilbert.relationships.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	ArrayList<Person> findAll();
	ArrayList<Person> findByfirstNameContaining(String search);

}
