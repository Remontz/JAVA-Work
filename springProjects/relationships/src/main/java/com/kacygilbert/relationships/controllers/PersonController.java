package com.kacygilbert.relationships.controllers;

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

import com.kacygilbert.relationships.models.Person;
import com.kacygilbert.relationships.services.PersonService;

@Controller
public class PersonController {

	@Autowired
	PersonService personServ;
	
	// Routes
	@GetMapping("/")
	public String index(@ModelAttribute("person") Person person, Model model) {
		List<Person> allPeople = personServ.allPeople();
		model.addAttribute("allPeople", allPeople);
		return "index.jsp";
	}
	@GetMapping("/dashboard")
	public String dashboard() {
		return "redirect:/";
	}
	
	// New Person Page
	@GetMapping("/person/new")
	public String newPerson(@ModelAttribute("person") Person person, Model model) {
		// to pass the select/list of all people...
		model.addAttribute("allPeople", personServ.allPeople() );
		return "newPerson.jsp";
	}
	// Create Person
	@PostMapping("person/create")
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "newPerson.jsp";
		} else {
			personServ.createPerson(person);
			return "redirect:/";
		}
	}
	
	@DeleteMapping("person/{id}/delete")
	public String deletePerson(@PathVariable("id") Long id, Model model) {
		personServ.deletePerson(id);
		return "redirect:/";
	}
	
	
}
