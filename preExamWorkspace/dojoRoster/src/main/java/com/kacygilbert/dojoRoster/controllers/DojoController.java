package com.kacygilbert.dojoRoster.controllers;

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

import com.kacygilbert.dojoRoster.models.Dojo;
import com.kacygilbert.dojoRoster.models.Ninja;
import com.kacygilbert.dojoRoster.services.DojoService;
import com.kacygilbert.dojoRoster.services.NinjaService;

@Controller
public class DojoController {

	@Autowired
	NinjaService ninjaServ;
	private final DojoService dojoServ;
	
	// Constructor
	public DojoController(DojoService dojoServ) {
		this.dojoServ = dojoServ;
	}
	
	// Routes

	// New License Page
	@GetMapping("/dojo/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo, Model model) {
		// to pass the select/list of all people...
		List<Ninja> allNinjas = ninjaServ.allNinjas();
		model.addAttribute("allNinjas", allNinjas);
		return "newDojo.jsp";
	}
	// Create License
	@PostMapping("/dojo/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		} else {
			dojoServ.createDojo(dojo);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/dojo/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoServ.findDojoById(id);
		model.addAttribute("dojo", dojo);
		return "showDojo.jsp";
	}
	
	@DeleteMapping("/dojo/{id}/delete")
	public String deleteDojo(@PathVariable("id") Long id, Model model) {
		dojoServ.deleteDojo(id);
		return "redirect:/";
	}
	
	
}
