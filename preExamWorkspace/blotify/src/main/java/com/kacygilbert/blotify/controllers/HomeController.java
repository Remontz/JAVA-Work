package com.kacygilbert.blotify.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kacygilbert.blotify.models.LoginUser;
import com.kacygilbert.blotify.models.User;
import com.kacygilbert.blotify.services.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService userServ;
	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("loginUser", new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult results, HttpSession session, Model model) {
		User loggedUser = userServ.register(newUser, results);
		if(results.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "index.jsp";
		} else {
			session.setAttribute("userid", loggedUser.getId());
			return "redirect:/home";
		}
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult results, HttpSession session, Model model) {
		User loggedUser = userServ.getOneByEmail(loginUser, results);
		if(results.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		} else {	
			// log in to session
			return "redirect:/home";
			}	
		}
	
	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
		
		Long id = (Long) session.getAttribute("userid");
		model.addAttribute("user", userServ.getOneById(id));
		return "home.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userid");  //there's also a session.invalidate to clear session.
		return "redirect:/";
	}
	

	
	
}
