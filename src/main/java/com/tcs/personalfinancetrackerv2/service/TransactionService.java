package com.tcs.personalfinancetrackerv2.service;

import com.tcs.personalfinancetrackerv2.entity.Transaction;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TransactionService {

    Transaction saveTransaction(Transaction transaction);

    List<Transaction> getAllTransactions();

    Optional<Transaction> getTransactionById(Long id);

    Transaction updateTransaction(Long id, Transaction transaction);

    void deleteTransaction(Long id);

    // Search
    List<Transaction> searchByCategory(String category);

    List<Transaction> searchByTransactionType(String transactionType);

    List<Transaction> searchByCategoryAndTransactionType(
            String category,
            String transactionType
    );

    // Pagination & Sorting
    Page<Transaction> getTransactions(
            int page,
            int size,
            String sortBy,
            String direction
    );

    // ==========================
    // Advanced Filters
    // ==========================

    List<Transaction> getTransactionsByDate(LocalDate date);

    List<Transaction> getTransactionsByDateRange(
            LocalDate startDate,
            LocalDate endDate
    );

    List<Transaction> getTransactionsByAmountRange(
            BigDecimal minAmount,
            BigDecimal maxAmount
    );
}