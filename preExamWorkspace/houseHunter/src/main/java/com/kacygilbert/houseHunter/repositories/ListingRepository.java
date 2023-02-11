package com.kacygilbert.houseHunter.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kacygilbert.houseHunter.models.Listing;

@Repository
public interface ListingRepository extends CrudRepository<Listing, Long> {
	List<Listing> findAll();
	Optional<Listing> findById(Long id);

}
