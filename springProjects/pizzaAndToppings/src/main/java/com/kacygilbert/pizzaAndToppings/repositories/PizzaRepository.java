package com.kacygilbert.pizzaAndToppings.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kacygilbert.pizzaAndToppings.models.Pizza;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza, Long> {
	List<Pizza> findAll();
}
