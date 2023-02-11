package com.kacygilbert.mvc2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kacygilbert.mvc2.models.Book;
import com.kacygilbert.mvc2.repositories.BookRepository;

@Service
public class BookService {
	// adding the book repository as a dependency
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	//returns all the books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	
	// creates a book
	public Book createBook(Book newBook) {
		return bookRepository.save(newBook);
	}
	
	// retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	//updates a Book
	public void updateBook(Book book) {
		bookRepository.save(book);
	}
	
	// deletes a book
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	
}
