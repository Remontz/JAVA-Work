package com.kacygilbert.mvc2.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kacygilbert.mvc2.models.Book;
import com.kacygilbert.mvc2.services.BookService;

@RestController
public class BooksApi {
	private final BookService bookService;
	
	public BooksApi(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/api/books")
	public List<Book> index() {
		return bookService.allBooks();
	}
	
	@PostMapping(value="/api/books")
	public Book create(
			@RequestParam(value="title") String title, 
			@RequestParam(value="description") String desc,
			@RequestParam(value="language") String lang,
			@RequestParam(value="numberOfPages") Integer numberOfPages) {
		Book book = new Book(title, desc, lang, numberOfPages);
		return bookService.createBook(book);
	}
	
	@RequestMapping("/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		return book;
	}
	
	@GetMapping("/api/books/{id}/edit")
	public String editBook(
			@PathVariable("id") Long id,
			Model model) {
		Book newBook = bookService.findBook(id);
		model.addAttribute("book", newBook);
		return "editBook.jsp";
	}
	@PutMapping("api/books/{id}/update")
	public String updateBook(
			@Valid
			@ModelAttribute("book") Book book,
			BindingResult result) {
		if(result.hasErrors()) {
			return "editBook.jsp";
		} else {
			bookService.updateBook(book);
			return "redirect:/";
		}
	}
	
	@DeleteMapping("api/books/{id}/delete")
	public String delete(
			@PathVariable("id") Long id,
			Model model) {
		bookService.deleteBook(id);
		return "redirect:/";
	}
	
}
