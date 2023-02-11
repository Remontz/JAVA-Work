package com.kacygilbert.teams.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kacygilbert.teams.models.Coach;

@Repository
public interface CoachRepository extends CrudRepository<Coach, Long> {
	List<Coach> findAll();
	Optional<Coach> findById(Long id);
}
