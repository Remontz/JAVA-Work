package com.kacygilbert.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class FruitController {
	@RequestMapping("/")
	public String index(Model model) {
		
		model.addAttribute("fruit", "banana");
		return "demo.jsp";
	}

}
