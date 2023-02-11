package com.kacygilbert.yogaCourse.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kacygilbert.yogaCourse.models.Instructor;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Long>{
	List<Instructor> findAll();
	Optional<Instructor> findByEmail(String email);
	Optional<Instructor> findById(Long id);

}
