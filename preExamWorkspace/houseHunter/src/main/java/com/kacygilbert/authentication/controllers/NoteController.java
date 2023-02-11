package com.kacygilbert.authentication.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kacygilbert.authentication.models.Note;
import com.kacygilbert.authentication.services.NoteService;
import com.kacygilbert.authentication.services.UserService;

@Controller
public class NoteController {

	@Autowired
	NoteService noteServ;
	@Autowired
	UserService userServ;
	
	@GetMapping("/note/new")
	public String newNote(@ModelAttribute("note") Note note, Model model) {
		model.addAttribute("allUsers", userServ.getAllUsers());
		return "newNote.jsp";
	}
	@PostMapping("/note/create")
	public String createListing(@Valid @ModelAttribute("note") Note note, BindingResult result) {
		if(result.hasErrors()) {
			return "newNote.jsp";
		} else {
			noteServ.createNote(note);
			return "redirect:/dashboard";
		}
	}
}
