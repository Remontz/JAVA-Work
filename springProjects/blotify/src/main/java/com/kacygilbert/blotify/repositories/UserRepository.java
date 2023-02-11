package com.kacygilbert.blotify.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kacygilbert.blotify.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	//save is built in so no need to create a new method/query for registration.
	// In order to get user id for home route
	Optional<User> findById(Long id);
	
	//Find user by email address
	Optional<User> findByEmail(String email);
}