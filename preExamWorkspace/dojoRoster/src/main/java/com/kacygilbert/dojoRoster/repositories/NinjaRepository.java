package com.kacygilbert.dojoRoster.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kacygilbert.dojoRoster.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	ArrayList<Ninja> findAll();
}
