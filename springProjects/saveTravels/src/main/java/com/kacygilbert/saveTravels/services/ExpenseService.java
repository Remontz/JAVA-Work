package com.kacygilbert.saveTravels.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kacygilbert.saveTravels.models.Expense;
import com.kacygilbert.saveTravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepo;
	
	public ExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	// returns all the expenses
	public ArrayList<Expense> allExpenses() {
		return expenseRepo.findAll();
	}
	
	// creates an expense
	public Expense createExpense (Expense newExpense) {
		return expenseRepo.save(newExpense);
	}
	
	// finds expense by id
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
	
	// updates an expense
	public void updateExpense(Expense expense) {
		expenseRepo.save(expense);
	}
	
	// deletes expense
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}
}
