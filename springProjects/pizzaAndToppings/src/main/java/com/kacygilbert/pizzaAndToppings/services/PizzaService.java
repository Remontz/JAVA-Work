package com.kacygilbert.pizzaAndToppings.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kacygilbert.pizzaAndToppings.models.Pizza;
import com.kacygilbert.pizzaAndToppings.repositories.PizzaRepository;

@Service
public class PizzaService {

	@Autowired
	private PizzaRepository pizzaRepo;
	
	public Pizza createPizza(Pizza pizza) {
		return pizzaRepo.save(pizza);
	}
	
	public List<Pizza> getAll() {
		return pizzaRepo.findAll();
	}
	
}