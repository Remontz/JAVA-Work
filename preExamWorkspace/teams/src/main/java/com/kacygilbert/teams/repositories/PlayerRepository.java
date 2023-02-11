package com.kacygilbert.teams.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kacygilbert.teams.models.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
	List<Player> findAll();
	Optional<Player> findById(Long id);
}
