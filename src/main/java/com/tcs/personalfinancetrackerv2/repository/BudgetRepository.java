package com.tcs.personalfinancetrackerv2.repository;

import com.tcs.personalfinancetrackerv2.entity.Budget;
import com.tcs.personalfinancetrackerv2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BudgetRepository extends JpaRepository<Budget, Long> {

    List<Budget> findByUser(User user);

    Optional<Budget> findByIdAndUser(Long id, User user);

    Optional<Budget> findByUserAndCategoryAndMonthAndYear(
            User user,
            String category,
            Integer month,
            Integer year
    );

}