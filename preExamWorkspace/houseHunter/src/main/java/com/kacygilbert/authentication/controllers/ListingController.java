package com.kacygilbert.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kacygilbert.authentication.models.Listing;
import com.kacygilbert.authentication.models.Note;
import com.kacygilbert.authentication.services.ListingService;
import com.kacygilbert.authentication.services.NoteService;
import com.kacygilbert.authentication.services.UserService;

@Controller
public class ListingController {

	@Autowired
	ListingService listingServ;
	@Autowired
	UserService userServ;
	@Autowired
	NoteService noteServ;
	
	@GetMapping("/listing/new")
	public String newListing(@ModelAttribute("listing") Listing listing, Model model) {
		model.addAttribute("allUsers", userServ.getAllUsers());
		return "newListing.jsp";
	}
	@PostMapping("/listing/create")
	public String createListing(@Valid @ModelAttribute("listing") Listing listing, BindingResult result) {
		if(result.hasErrors()) {
			return "newListing.jsp";
		} else {
			listingServ.createListing(listing);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/listing/{id}")
	public String viewListing(@PathVariable("id") Long id, Model model, HttpSession session, @ModelAttribute("note") Note note) {
		model.addAttribute("listing", listingServ.getListById(id));
		model.addAttribute("allNotes", noteServ.allNotes());
		model.addAttribute("allUsers", userServ.getAllUsers());
		Long userId = (Long) session.getAttribute("userid");
		model.addAttribute("user", userServ.getOneById(userId));
		return "viewListing.jsp";
	}
	
	@GetMapping("/listing/{id}/edit")
	public String editListing(@PathVariable("id") Long id, Model model) {
		model.addAttribute("listing", listingServ.getListById(id));
		return "editListing.jsp";
	}
	@PostMapping("/listing/{id}/update")
	public String updateListing(@Valid @ModelAttribute("listing") Listing listing, BindingResult result) {
		if(result.hasErrors()) {
			return "editListing.jsp";
		} else {
			listingServ.updateListing(listing);
			return "redirect:/listing/{id}";
		}
	}
	
	@DeleteMapping("/listing/{id}/delete")
	public String deleteListing(@PathVariable("id") Long id) {
		listingServ.deleteListing(id);
		return "redirect:/";
	}
	
}
