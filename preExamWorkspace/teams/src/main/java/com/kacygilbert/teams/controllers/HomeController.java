package com.kacygilbert.teams.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.kacygilbert.teams.models.Team;
import com.kacygilbert.teams.services.TeamService;

@Controller
public class HomeController {
	
	@Autowired
	TeamService teamServ;

	@GetMapping("/")
	public String index(Model model) {
		List<Team> allTeams = teamServ.allTeams();
		model.addAttribute("allTeams", allTeams);
		return "index.jsp";
	}
	
	
	
}
