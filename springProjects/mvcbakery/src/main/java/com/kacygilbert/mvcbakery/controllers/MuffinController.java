package com.kacygilbert.mvcbakery.controllers;


import java.util.List;

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
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

import com.kacygilbert.mvcbakery.models.Muffin;
import com.kacygilbert.mvcbakery.services.ChefService;
import com.kacygilbert.mvcbakery.services.MuffinService;

@Controller
public class MuffinController {
	// Import Service
	@Autowired
	ChefService chefService;
	private final MuffinService muffinServ;
	
	public MuffinController(MuffinService muffinServ) {
		this.muffinServ = muffinServ;
	}
	
	//I want to grab data from my database in order to display information.
	@GetMapping("/") //Request Mapping is considered older tech, alot of companies still use it. 
	public String index(@ModelAttribute("muffin") Muffin muffin, Model model) {
		List<Muffin> allMuffins = muffinServ.allMuffins();
		model.addAttribute("muffins", allMuffins);
		return "index.jsp";
	}
	
	@GetMapping("/muffin/new")
	public String newMuffin(@ModelAttribute("muffin") Muffin muffin, Model model) {
		//to pass in the list of all chefs
		model.addAttribute("allChefs", chefService.allChefs() );		
		return "newMuffin.jsp";
	}
	
	@PostMapping("/muffin/create")
	public String createMuffin(@Valid @ModelAttribute("muffin") Muffin muffin, BindingResult result) {
		if(result.hasErrors()) {
			return "newMuffin.jsp";
		} else {
			muffinServ.createMuffin(muffin);	
			return "redirect:/";
		}
	}
	
	@GetMapping("/muffin/{id}/edit") //Save the CRUD terminology for the route that does the actual processing.
	public String editMuffin(@PathVariable("id") Long id, Model model) {
		Muffin newMuffin = muffinServ.findMuffinById(id);
		model.addAttribute("muffin", newMuffin);
		return "editMuffin.jsp";
	}
	@PutMapping("/muffin/{id}/update")
	public String updatemuffin(@Valid @ModelAttribute("muffin") Muffin muffin, BindingResult result) {
		if(result.hasErrors()) {
			return "editMuffin.jsp";
		} else {
			muffinServ.updateMuffin(muffin);
			return "redirect:/";
		}
	}
	
	@DeleteMapping("/muffin/{id}/delete")
	public String delete(@PathVariable("id") Long id, Model model) {
		muffinServ.deleteMuffin(id);
		return "redirect:/";
	}
}
