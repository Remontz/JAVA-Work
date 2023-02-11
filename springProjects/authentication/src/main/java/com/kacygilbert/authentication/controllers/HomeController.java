package com.kacygilbert.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kacygilbert.authentication.models.Book;
import com.kacygilbert.authentication.models.LoginUser;
import com.kacygilbert.authentication.models.User;
import com.kacygilbert.authentication.services.BookService;
import com.kacygilbert.authentication.services.UserService;

@Controller
public class HomeController {
	
    // Add once service is implemented:
    @Autowired
    private UserService userServ;
    @Autowired
    private BookService bookServ;
    
    @GetMapping("/")
    public String index(Model model) {
        // Bind empty User and LoginUser objects to the JSP to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("loginUser", new LoginUser());
        return "index.jsp";
    }
    
    @GetMapping("/books")
    public String loginSuccess(HttpSession session, Model model ) {
    	Long id = (Long) session.getAttribute("userid");
    	model.addAttribute("user", userServ.getOneById(id));
    	model.addAttribute("allBooks", bookServ.getAllBooks());
    	return "success.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
        // TO-DO Later -- call a register method in the service 
        // to do some extra validations and create a new user!
    	User loggedUser = userServ.register(newUser, result);
        
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        } else {
        	// No errors! 
        	// TO-DO Later: Store their ID from the DB in session, in other words, log them in.
        	session.setAttribute("userid", loggedUser.getId()); 	
        }
        return "redirect:/books";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        User user = userServ.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        } else {
        	// No errors! 
        	// TO-DO Later: Store their ID from the DB in session,in other words, log them in.
        	session.setAttribute("userid", user.getId());
        }    
        return "redirect:/books";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("userid");
    	return "redirect:/";
    }
    
    @GetMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
    	return "newBook.jsp";
    }
    @PostMapping("/books/create")
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult results) {
    	if(results.hasErrors()) {
    		return "newBook.jsp";
    	} else {
    		bookServ.createBook(book);
    	}
    	
    	return "redirect:/books";
    }
    
    @GetMapping("/books/{id}")
    public String showBook(@PathVariable("id") Long id, Model model) {
    	Book book = bookServ.getOneById(id);
    	model.addAttribute("book", book);
    	return "showBook.jsp";
    }
}
