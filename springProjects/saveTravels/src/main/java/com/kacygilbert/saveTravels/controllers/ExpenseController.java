package com.kacygilbert.saveTravels.controllers;

import java.util.ArrayList;

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
import org.springframework.web.bind.annotation.PutMapping;

import com.kacygilbert.saveTravels.models.Expense;
import com.kacygilbert.saveTravels.services.ExpenseService;

@Controller
public class ExpenseController {
	@Autowired
	ExpenseService expenseServ;
	
	
	@GetMapping("/")
	public String index(Model model) {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String index(
			@ModelAttribute("expense") Expense expense,
			Model model) {
		ArrayList<Expense> expenses = expenseServ.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	@PostMapping("/expenses")
	public String index(
			@Valid
			@ModelAttribute("expense") Expense expense,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			ArrayList<Expense> expenses = expenseServ.allExpenses();
			model.addAttribute("expenses",expenses);
			return "index.jsp";
		}
		expenseServ.createExpense(expense);
		return "redirect:/";
	}
	
	@GetMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id,
			Model model) {
		Expense expense = expenseServ.findExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	@PutMapping("/expenses/update/{id}")
	public String update(@Valid
			@ModelAttribute("expense") Expense expense,
			BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			expenseServ.updateExpense(expense);
			return "redirect:/";
		}
	}
	@DeleteMapping("/expenses/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		expenseServ.deleteExpense(id);
		return "redirect:/";
	}
	
	@GetMapping("/expenses/show/{id}")
	public String show(@PathVariable("id") Long id,
			Model model) {
		Expense expense = expenseServ.findExpense(id);
		model.addAttribute("expense", expense);
		return "show.jsp";
	}
	
	
}
