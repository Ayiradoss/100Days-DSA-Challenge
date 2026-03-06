package com.expenso.controller;

import com.expenso.dto.ExpenseRequestDTO;
import com.expenso.dto.ExpenseResponseDTO;
import com.expenso.model.Category;
import com.expenso.model.Expense;
import com.expenso.model.User;
import com.expenso.repository.CategoryRepository;
import com.expenso.repository.UserRepository;
import com.expenso.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public ExpenseController(ExpenseService expenseService, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.expenseService = expenseService;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @PostMapping
    public ResponseEntity<?> addExpense(@Valid @RequestBody ExpenseRequestDTO req) {
        Optional<User> userOpt = userRepository.findById(req.getUserId());
        Optional<Category> catOpt = categoryRepository.findById(req.getCategoryId());
        if (userOpt.isEmpty() || catOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid userId or categoryId");
        }
        Expense e = Expense.builder()
                .title(req.getTitle())
                .amount(req.getAmount())
                .date(req.getDate())
                .user(userOpt.get())
                .category(catOpt.get())
                .build();
        Expense saved = expenseService.addExpense(e);
        return ResponseEntity.status(HttpStatus.CREATED).body(toDto(saved));
    }

    @GetMapping
    public ResponseEntity<List<ExpenseResponseDTO>> getAll() {
        List<ExpenseResponseDTO> list = expenseService.getAllExpenses().stream().map(this::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody ExpenseRequestDTO req) {
        Optional<User> userOpt = userRepository.findById(req.getUserId());
        Optional<Category> catOpt = categoryRepository.findById(req.getCategoryId());
        if (userOpt.isEmpty() || catOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid userId or categoryId");
        }
        Expense e = Expense.builder()
                .title(req.getTitle())
                .amount(req.getAmount())
                .date(req.getDate())
                .user(userOpt.get())
                .category(catOpt.get())
                .build();
        try {
            Expense updated = expenseService.updateExpense(id, e);
            return ResponseEntity.ok(toDto(updated));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }

    private ExpenseResponseDTO toDto(Expense e) {
        return ExpenseResponseDTO.builder()
                .id(e.getId())
                .title(e.getTitle())
                .amount(e.getAmount())
                .date(e.getDate())
                .categoryId(e.getCategory() != null ? e.getCategory().getId() : null)
                .categoryName(e.getCategory() != null ? e.getCategory().getName() : null)
                .userId(e.getUser() != null ? e.getUser().getId() : null)
                .userName(e.getUser() != null ? e.getUser().getName() : null)
                .build();
    }
}
