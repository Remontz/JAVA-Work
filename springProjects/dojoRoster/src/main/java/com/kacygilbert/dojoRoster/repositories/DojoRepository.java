package com.kacygilbert.dojoRoster.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kacygilbert.dojoRoster.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {
	ArrayList<Dojo> findAll();
}
