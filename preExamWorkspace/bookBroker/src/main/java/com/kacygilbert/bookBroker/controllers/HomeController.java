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

import com.kacygilbert.bookBroker.models.LoginUser;
import com.kacygilbert.bookBroker.models.User;
import com.kacygilbert.bookBroker.services.BookService;
import com.kacygilbert.bookBroker.services.UserService;

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
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
    	User loggedUser = userServ.register(newUser, result);
        
        if(result.hasErrors()) {
            model.addAttribute("loginUser", new LoginUser());
            return "index.jsp";
        } else {
        	session.setAttribute("userid", loggedUser.getId()); 	
        }
        return "redirect:/dashboard";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, Model model, HttpSession session) {
        
        User loggedUser = userServ.getOneByEmail(loginUser, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        } else {
        	// No errors! 
        	// TO-DO Later: Store their ID from the DB in session,in other words, log them in.
        	session.setAttribute("userid", loggedUser.getId());
        }    
        return "redirect:/dashboard";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("userid");
    	return "redirect:/";
    }
    
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
    	model.addAttribute("user", userServ.getOneById((Long) session.getAttribute("userid")));
    	model.addAttribute("allBooks", bookServ.allBooks());
    	return "dashboard.jsp";
    }
    
}
