package com.kacygilbert.mvcbakery.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kacygilbert.mvcbakery.models.Muffin;

	//The levers/Control board of the machine...the repository stores all the queries....
	
@Repository
public interface MuffinRepository extends CrudRepository<Muffin, Long> {
		List<Muffin> findAll();  // Goes to the DB and grabs everything...the only command needed.
		List<Muffin> findByFrostingContaining(String search);
		Long countByFrostingContaining(String search);
}

