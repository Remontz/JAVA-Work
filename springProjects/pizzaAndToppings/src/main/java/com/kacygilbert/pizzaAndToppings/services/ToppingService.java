package com.kacygilbert.pizzaAndToppings.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kacygilbert.pizzaAndToppings.models.Topping;
import com.kacygilbert.pizzaAndToppings.repositories.ToppingRepository;

@Service
public class ToppingService {
	@Autowired
	private ToppingRepository toppingRepo;
	
	public Topping createTopping(Topping topping) {
		return toppingRepo.save(topping);
	}
	
	public List<Topping> getAll() {
		return toppingRepo.findAll();
	}
}
