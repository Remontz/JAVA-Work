package com.kacygilbert.bookBroker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kacygilbert.bookBroker.models.Author;
import com.kacygilbert.bookBroker.repositories.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepo;
	
	public List<Author> getAllAuthors()  {
		return authorRepo.findAll();
	}
	
	public Author getAuthorById(Long id) {
		Optional<Author> optionalAuthor = authorRepo.findById(id);
		if(optionalAuthor.isPresent()) {
			return optionalAuthor.get();
		} else {
			return null;
		}
	}
	
	public Author createAuthor(Author newAuthor) {
		return authorRepo.save(newAuthor);
	}
	public void updateAuthor(Author author) {
		authorRepo.save(author);
	}
	public void deleteAuthor(Long id) {
		authorRepo.deleteById(id);
	}
}

