package com.kacygilbert.pizzaAndToppings.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kacygilbert.pizzaAndToppings.models.Pizza;
import com.kacygilbert.pizzaAndToppings.services.PizzaService;
import com.kacygilbert.pizzaAndToppings.services.ToppingService;

@Controller
public class PizzaController {
	@Autowired
	private PizzaService pizzaServ;
	@Autowired
	private ToppingService toppingServ;
	
	@GetMapping("/")
	public String index(Model model) {
		//Have to add to model attributes because there we are bringing in two models(Pizza and Topping)
		model.addAttribute("allPizzas", pizzaServ.getAll());
		model.addAttribute("allToppings", toppingServ.getAll());
		return "index.jsp";
	}
	
	@GetMapping("/pizza/create")
	public String newPizza(@ModelAttribute("pizza") Pizza pizza) {
		return "newPizza.jsp";		
	}
	@PostMapping("/pizza/create")
	public String createPizza(@Valid @ModelAttribute("pizza") Pizza pizza, BindingResult result) {
		if(result.hasErrors()) {
			return "newPizza.jsp";
		} else {
			pizzaServ.createPizza(pizza);
			return "redirect:/";
		}
	}
}
