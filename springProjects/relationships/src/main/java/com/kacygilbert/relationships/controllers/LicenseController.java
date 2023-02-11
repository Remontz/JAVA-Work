package com.kacygilbert.relationships.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kacygilbert.relationships.models.License;
import com.kacygilbert.relationships.models.Person;
import com.kacygilbert.relationships.services.LicenseService;
import com.kacygilbert.relationships.services.PersonService;

@Controller
public class LicenseController {
	// Dependency Injections...EARLY!
	@Autowired
	PersonService personService;
	private final LicenseService licServ;
	
	// Constructor
	public LicenseController(LicenseService licServ) {
		this.licServ = licServ;
	}
	
	// Routes

	// New License Page
	@GetMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		// to pass the select/list of all people...
		ArrayList<Person> allPeople = personService.allPeople();
		model.addAttribute("allPeople", allPeople);
		return "newLicense.jsp";
	}
	// Create License
	@PostMapping("license/create")
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors()) {
			return "newLicense.jsp";
		} else {
			licServ.createLicense(license);
			return "redirect:/person/{license.person.id}";
		}
	}
	
	
	
}
