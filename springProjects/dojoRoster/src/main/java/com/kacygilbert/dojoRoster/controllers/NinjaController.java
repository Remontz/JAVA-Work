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
public class NinjaController {

	@Autowired
	DojoService dojoServ;
	private final NinjaService ninjaServ;
	
	public NinjaController(NinjaService ninjaServ) {
		this.ninjaServ = ninjaServ;
	}
	
	@GetMapping("/")
	public String index(@ModelAttribute("ninja") Ninja ninja, @ModelAttribute("dojo") Dojo dojo, Model model) {
		List<Ninja> allNinjas = ninjaServ.allNinjas();
		List<Dojo> allDojos = dojoServ.allDojos();
		model.addAttribute("allNinjas", allNinjas);
		model.addAttribute("allDojos", allDojos);
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "redirect:/";
	}
	
	@GetMapping("/ninja/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, @ModelAttribute("dojo") Dojo dojo, Model model) {
		model.addAttribute("allNinjas", ninjaServ.allNinjas());
		model.addAttribute("allDojos", dojoServ.allDojos());
		return "newNinja.jsp";
	}
	@PostMapping("/ninja/create")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "newNinja.jsp";
		} else {
			ninjaServ.createNinja(ninja);
			return "redirect:/";
		}
	}
	
	@DeleteMapping("/ninja/{id}/delete")
	public String deleteNinja(@PathVariable("id") Long id, Model model) {
		ninjaServ.deleteNinja(id);
		return "redirect:/";
	}
}
