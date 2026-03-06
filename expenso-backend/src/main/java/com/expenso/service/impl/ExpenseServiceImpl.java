package com.expenso.service.impl;

import com.expenso.model.Expense;
import com.expenso.repository.ExpenseRepository;
import com.expenso.service.ExpenseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseServiceImpl(ExpenseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Expense addExpense(Expense expense) {
        return repository.save(expense);
    }

    @Override
    public Expense updateExpense(Long id, Expense expense) {
        Optional<Expense> existing = repository.findById(id);
        if (existing.isEmpty()) {
            throw new IllegalArgumentException("Expense not found: " + id);
        }
        Expense e = existing.get();
        e.setTitle(expense.getTitle());
        e.setAmount(expense.getAmount());
        e.setDate(expense.getDate());
        e.setCategory(expense.getCategory());
        e.setUser(expense.getUser());
        return repository.save(e);
    }

    @Override
    public void deleteExpense(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    @Override
    public List<Expense> getExpensesByCategory(Long categoryId) {
        return repository.findByCategoryId(categoryId);
    }

    @Override
    public Optional<Expense> findById(Long id) {
        return repository.findById(id);
    }
}
