package com.kacygilbert.bookBroker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kacygilbert.bookBroker.models.Book;
import com.kacygilbert.bookBroker.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepo;
	
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	
	public Book getBookById(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	public Book createBook(Book newBook) {
		return bookRepo.save(newBook);
	}
	public void updateBook(Book book) {
		bookRepo.save(book);
	}
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
}
