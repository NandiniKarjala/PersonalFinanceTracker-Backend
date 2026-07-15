package com.tcs.personalfinancetrackerv2.repository;

import com.tcs.personalfinancetrackerv2.entity.Transaction;
import com.tcs.personalfinancetrackerv2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByUser(User user);

    Optional<Transaction> findByIdAndUser(Long id, User user);

    List<Transaction> findByUserAndDateBetween(
            User user,
            LocalDate startDate,
            LocalDate endDate
    );

    List<Transaction> findByUserAndCategory(
            User user,
            String category
    );

    List<Transaction> findByCategoryContainingIgnoreCase(String category);

    List<Transaction> findByTransactionTypeIgnoreCase(String transactionType);

    List<Transaction> findByCategoryContainingIgnoreCaseAndTransactionTypeIgnoreCase(
            String category,
            String transactionType
    );

    List<Transaction> findByDate(LocalDate date);

    List<Transaction> findByDateBetween(
            LocalDate startDate,
            LocalDate endDate
    );

    List<Transaction> findByAmountBetween(
            BigDecimal min,
            BigDecimal max
    );
}