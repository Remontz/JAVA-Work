package com.kacygilbert.teams.controllers;

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

import com.kacygilbert.teams.models.Team;
import com.kacygilbert.teams.services.TeamService;

@Controller
public class TeamController {

	@Autowired
	TeamService teamServ;
	
	
	@GetMapping("/teams/new")
	public String newTeam(@ModelAttribute("team") Team team) {
		return "newTeam.jsp";
	}
	@PostMapping("/teams/create")
	public String createTeam(@Valid @ModelAttribute("team") Team team, BindingResult result) {
		if(result.hasErrors()) {
			return "newTeam.jsp";
		} else {
			teamServ.createTeam(team);
			return "redirect:/";
		}
	}
	
	@GetMapping("/teams/{id}")
	public String viewTeam(@PathVariable("id") Long id, Model model) {
		Team team = teamServ.getTeamById(id);
		model.addAttribute("team", team);
		return "viewTeam.jsp";
	}
	
	@GetMapping("/teams/{id}/edit")
	public String editTeam(@PathVariable("id") Long id, Model model) {
		Team team = teamServ.getTeamById(id);
		model.addAttribute("team", team);
		return "editTeam.jsp";
	}
	@PostMapping("/teams/{id}/update")
	public String updateTeam(@Valid @ModelAttribute("team") Team team, BindingResult result) {
		if(result.hasErrors()) {
			return "editTeam.jsp";
		} else {
			teamServ.updateTeam(team);
			return "redirect:/teams/{id}";
		}
	}
	
	@DeleteMapping("/teams/{id}/delete")
	public String deleteTeam(@PathVariable("id") Long id) {
		teamServ.deleteTeam(id);
		return "redirect:/";
	}
	
}
