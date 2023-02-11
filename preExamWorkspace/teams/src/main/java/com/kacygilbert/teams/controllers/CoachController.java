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

import com.kacygilbert.teams.models.Coach;
import com.kacygilbert.teams.models.Team;
import com.kacygilbert.teams.services.CoachService;
import com.kacygilbert.teams.services.TeamService;

@Controller
public class CoachController {
	@Autowired
	CoachService coachServ;
	@Autowired
	TeamService teamServ;
	
	@GetMapping("/coaches/new")
	public String newCoach(@ModelAttribute("coach") Coach coach, Model model) {
		List<Team> allTeams = teamServ.allTeams();
		model.addAttribute("allTeams", allTeams);
		return "newCoach.jsp";
	}
	@PostMapping("/coaches/create")
	public String createTeam(@Valid @ModelAttribute("coach") Coach coach, BindingResult result) {
		if(result.hasErrors()) {
			return "newCoach.jsp";
		} else {
			coachServ.createCoach(coach);
			return "redirect:/";
		}
	}
	
	@GetMapping("/coaches/{id}")
	public String viewCoach(@PathVariable("id") Long id, Model model) {
		Coach coach = coachServ.getCoachById(id);
		model.addAttribute("coach", coach);
		return "viewCoach.jsp";
	}
	
	@GetMapping("/coaches/{id}/edit")
	public String editCoach(@PathVariable("id") Long id, Model model) {
		Coach coach = coachServ.getCoachById(id);
		model.addAttribute("coach", coach);
		return "editCoach.jsp";
	}
	@PostMapping("/coaches/{id}/update")
	public String updateCoach(@Valid @ModelAttribute("coach") Coach coach, BindingResult result) {
		if(result.hasErrors()) {
			return "editCoach.jsp";
		} else {
			coachServ.updateCoach(coach);
			return "redirect:/coaches/{id}";
		}
	}
	
	@DeleteMapping("/coaches/{id}/delete")
	public String deleteCoach(@PathVariable("id") Long id) {
		coachServ.deleteCoach(id);
		return "redirect:/";
	}
}
