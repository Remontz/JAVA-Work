package com.kacygilbert.mvc2.controllers;
//Going forward we'll only need this one controller, not an API controller.
// The convention is to have a controller for each model.

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.kacygilbert.mvc2.models.Book;
import com.kacygilbert.mvc2.services.BookService;

@Controller //The difference between Rest is that Rest will respond with JSONs and raw data.  Controller will respond with an actual jsp page.
public class BookController {
	@Autowired
	BookService bookService; //Does dependency injection.
	
	@GetMapping("/books/{id}")
	public String index(
			Model model,
			@PathVariable("id") Long id) {
		System.out.println(id);
		Book book = bookService.findBook(id);
		System.out.println(book);
		
		model.addAttribute("book", book);	
		
		return "show.jsp";
	}
	
	@GetMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "index.jsp";
	}
	@PostMapping("/books")
	public String create(
			@Valid
			@ModelAttribute("book") Book book,
			BindingResult result) { 
		
		if(result.hasErrors()) {
			return "new.jsp";
		}
		bookService.createBook(book);
		return "redirect:/books";
	}
	
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "new.jsp";
	}
	
	@GetMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id,
			Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "/books/edit.jsp";
	}
	
	@PutMapping("/books/{id}")
	public String update(@Valid
			@ModelAttribute("book") Book book,
			BindingResult result) {
		if(result.hasErrors()) {
			return "/books/edit.jsp";
		} else {
			bookService.updateBook(book);
			return "redirect:/books";
		}
	}
	
	
}
