package com.kacygilbert.bookBroker.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kacygilbert.bookBroker.models.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
List<Author> findAll();
Optional<Author> findByName(String name);
Optional<Author> findById(Long Id);
}
