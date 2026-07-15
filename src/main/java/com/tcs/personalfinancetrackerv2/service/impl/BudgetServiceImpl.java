package com.tcs.personalfinancetrackerv2.service.impl;

import com.tcs.personalfinancetrackerv2.entity.Budget;
import com.tcs.personalfinancetrackerv2.entity.User;
import com.tcs.personalfinancetrackerv2.repository.BudgetRepository;
import com.tcs.personalfinancetrackerv2.security.SecurityService;
import com.tcs.personalfinancetrackerv2.service.BudgetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetServiceImpl implements BudgetService {

    private final BudgetRepository budgetRepository;
    private final SecurityService securityService;

    public BudgetServiceImpl(
            BudgetRepository budgetRepository,
            SecurityService securityService) {

        this.budgetRepository = budgetRepository;
        this.securityService = securityService;
    }

    @Override
    public Budget saveBudget(Budget budget) {

        User currentUser = securityService.getCurrentUser();

        budget.setUser(currentUser);

        return budgetRepository.save(budget);
    }

    @Override
    public List<Budget> getAllBudgets() {

        User currentUser = securityService.getCurrentUser();

        return budgetRepository.findByUser(currentUser);
    }

    @Override
    public Optional<Budget> getBudgetById(Long id) {

        User currentUser = securityService.getCurrentUser();

        return budgetRepository.findByIdAndUser(id, currentUser);
    }

    @Override
    public Budget updateBudget(Long id, Budget budget) {

        User currentUser = securityService.getCurrentUser();

        Budget existingBudget = budgetRepository
                .findByIdAndUser(id, currentUser)
                .orElseThrow(() -> new RuntimeException("Budget not found"));

        existingBudget.setCategory(budget.getCategory());
        existingBudget.setMonthlyLimit(budget.getMonthlyLimit());
        existingBudget.setMonth(budget.getMonth());
        existingBudget.setYear(budget.getYear());

        existingBudget.setUser(currentUser);

        return budgetRepository.save(existingBudget);
    }

    @Override
    public void deleteBudget(Long id) {

        User currentUser = securityService.getCurrentUser();

        Budget budget = budgetRepository
                .findByIdAndUser(id, currentUser)
                .orElseThrow(() -> new RuntimeException("Budget not found"));

        budgetRepository.delete(budget);
    }

}