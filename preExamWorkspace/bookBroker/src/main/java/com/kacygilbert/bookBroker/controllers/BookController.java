package com.kacygilbert.bookBroker.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kacygilbert.bookBroker.models.Book;
import com.kacygilbert.bookBroker.services.AuthorService;
import com.kacygilbert.bookBroker.services.BookService;
import com.kacygilbert.bookBroker.services.UserService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService bookServ;
	@Autowired
	UserService userServ;
	@Autowired
	AuthorService authorServ;
	
	@GetMapping("/new")
	public String newBook(@ModelAttribute("book") Book book, Model model, HttpSession session) {
		model.addAttribute("user", userServ.getOneById((Long)session.getAttribute("userid")));
		model.addAttribute("allUsers", userServ.getAllUsers());
		model.addAttribute("allAuthors", authorServ.getAllAuthors());
		return "newBook.jsp";
	}
	@PostMapping("/create")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "newBook.jsp";
		} else {
			bookServ.createBook(book);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/{id}")
	public viewBook(@PathVariable("id") Long id, 
}

