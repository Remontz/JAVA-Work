package com.kacygilbert.bookBroker.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kacygilbert.bookBroker.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	
	List<Book> findAll();
	Optional<Book> findByUser(Long id);
	Optional<Book> findById(Long id);
}
