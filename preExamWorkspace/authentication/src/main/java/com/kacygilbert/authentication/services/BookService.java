package com.kacygilbert.authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kacygilbert.authentication.models.Book;
import com.kacygilbert.authentication.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}
	
	public Book createBook(Book newBook) {
		return bookRepo.save(newBook);
	}
	
	public Book getOneById(Long id) {
		Optional<Book> book = bookRepo.findById(id);
		if(book.isPresent()) {
			return book.get();
		} else {	
			return null;
		}
	}
	
	
}
