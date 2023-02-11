package com.kacygilbert.teams.controllers;

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

import com.kacygilbert.teams.models.Player;
import com.kacygilbert.teams.models.Team;
import com.kacygilbert.teams.services.PlayerService;
import com.kacygilbert.teams.services.TeamService;

@Controller
public class PlayerController {
	@Autowired
	PlayerService playerServ;
	@Autowired
	TeamService teamServ;
	
	@GetMapping("/players/new")
	public String newPlayer(@ModelAttribute("player") Player player, Model model) {
		List<Team> allTeams = teamServ.allTeams();
		model.addAttribute("allTeams", allTeams);
		return "newPlayer.jsp";
	}
	@PostMapping("/players/create")
	public String createPlayer(@Valid @ModelAttribute("player") Player player, BindingResult result) {
		if(result.hasErrors()) {
			return "newPlayer.jsp";
		} else {
			playerServ.createPlayer(player);
			return "redirect:/";
		}
	}
	
	@GetMapping("/players/{id}")
	public String viewPlayer(@PathVariable("id") Long id, Model model) {
		Player player = playerServ.getPlayerById(id);
		model.addAttribute("player", player);
		return "viewPlayer.jsp";
	}
	
	@GetMapping("/players/{id}/edit")
	public String editPlayer(@PathVariable("id") Long id, Model model) {
		Player player = playerServ.getPlayerById(id);
		model.addAttribute("player", player);
		return "editPlayer.jsp";
	}
	
	@PostMapping("/players/{id}/update")
	public String updatePlayer(@Valid @ModelAttribute("player") Player player, BindingResult result) {
		if(result.hasErrors()) {
			return "editPlayer.jsp";
		} else {
			playerServ.updatePlayer(player);
			return "redirect:/players/{id}";
		}
	}
	
	@DeleteMapping("/players/{id}/delete")
	public String deletePlayer(@PathVariable("id") Long id) {
		playerServ.deletePlayer(id);
		return "redirect:/";
	}
}
