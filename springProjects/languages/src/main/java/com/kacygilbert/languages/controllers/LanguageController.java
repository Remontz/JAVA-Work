package com.kacygilbert.languages.controllers;

import java.util.ArrayList;

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
import org.springframework.web.bind.annotation.PutMapping;

import com.kacygilbert.languages.models.Language;
import com.kacygilbert.languages.services.LanguageService;

@Controller
public class LanguageController {
	@Autowired
	LanguageService langServ;
	
	@GetMapping("/")
	public String index(Model model) {
		return "redirect:/languages";
	}
	
	@GetMapping("/languages")
	public String index(
			@ModelAttribute("language") Language language,
			Model model) {
		ArrayList<Language> languages = langServ.allLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	@PostMapping("/languages/create")
	public String createLanguage(
			@Valid
			@ModelAttribute("language") Language language,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			ArrayList<Language> languages = langServ.allLanguages();
			model.addAttribute("languages", languages);
			return "index.jsp";
		}
		langServ.createLanguage(language);
		return "redirect:/";
	}
	
	//Show One Language
	@GetMapping("/languages/show/{id}")
	public String showLanguage(@PathVariable("id") Long id,
			Model model) {
		Language language = langServ.findLanguage(id);
		model.addAttribute("language", language);
		return "show.jsp";
	}
	
	// Show Edit Page
	@GetMapping("/languages/edit/{id}")
	public String editLanguage(@PathVariable("id") Long id,
			Model model) {
		Language language = langServ.findLanguage(id);
		model.addAttribute("language", language);
		return "edit.jsp";
	}
	// Perform Update
	@PutMapping("/languages/update/{id}")
	public String updateLanguage(@Valid
			@ModelAttribute("language") Language language,
			BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			langServ.updateLanguage(language);
			return "redirect:/";
		}
	}
	
	// Delete Language
	@DeleteMapping("/languages/delete/{id}")
	public String deleteLanguage(@PathVariable("id") Long id) {
		langServ.deleteLanguage(id);
		return "redirect:/";
	}
	
	
}
