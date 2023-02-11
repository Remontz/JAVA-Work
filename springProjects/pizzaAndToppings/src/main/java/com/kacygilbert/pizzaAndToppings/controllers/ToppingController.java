package com.kacygilbert.pizzaAndToppings.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kacygilbert.pizzaAndToppings.models.Topping;
import com.kacygilbert.pizzaAndToppings.services.ToppingService;

@RequestMapping("/topping")
@Controller
public class ToppingController {
	@Autowired
	private ToppingService toppingServ;
	
	@GetMapping("/create")
	public String newTopping(@ModelAttribute("topping") Topping topping) {
		return "newTopping.jsp";
	}
	@PostMapping("/create")
	public String createTopping(@Valid @ModelAttribute("topping") Topping topping, BindingResult result) {
		if(result.hasErrors()) {
			return "newTopping.jsp";
		} else {
			toppingServ.createTopping(topping);
			return "redirect:/";
		}
	}
}
