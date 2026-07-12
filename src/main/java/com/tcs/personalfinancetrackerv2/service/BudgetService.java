package com.tcs.personalfinancetrackerv2.service;

import com.tcs.personalfinancetrackerv2.entity.Budget;

import java.util.List;
import java.util.Optional;

public interface BudgetService {

    Budget saveBudget(Budget budget);

    List<Budget> getAllBudgets();

    Optional<Budget> getBudgetById(Long id);

    Budget updateBudget(Long id, Budget budget);

    void deleteBudget(Long id);

}