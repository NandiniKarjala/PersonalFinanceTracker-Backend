package com.tcs.personalfinancetrackerv2.service.impl;

import com.tcs.personalfinancetrackerv2.entity.Transaction;
import com.tcs.personalfinancetrackerv2.entity.User;
import com.tcs.personalfinancetrackerv2.repository.TransactionRepository;
import com.tcs.personalfinancetrackerv2.security.SecurityService;
import com.tcs.personalfinancetrackerv2.service.TransactionService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final SecurityService securityService;

    public TransactionServiceImpl(
            TransactionRepository transactionRepository,
            SecurityService securityService) {

        this.transactionRepository = transactionRepository;
        this.securityService = securityService;
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {

        User currentUser = securityService.getCurrentUser();

        transaction.setUser(currentUser);

        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {

        User currentUser = securityService.getCurrentUser();

        return transactionRepository.findByUser(currentUser);
    }

    @Override
    public Optional<Transaction> getTransactionById(Long id) {

        User currentUser = securityService.getCurrentUser();

        return transactionRepository.findByIdAndUser(id, currentUser);
    }

    @Override
    public Transaction updateTransaction(Long id, Transaction transaction) {

        User currentUser = securityService.getCurrentUser();

        Transaction existingTransaction = transactionRepository
                .findByIdAndUser(id, currentUser)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        existingTransaction.setAmount(transaction.getAmount());
        existingTransaction.setCategory(transaction.getCategory());
        existingTransaction.setTransactionType(transaction.getTransactionType());
        existingTransaction.setDescription(transaction.getDescription());
        existingTransaction.setDate(transaction.getDate());

        existingTransaction.setUser(currentUser);

        return transactionRepository.save(existingTransaction);
    }

    @Override
    public void deleteTransaction(Long id) {

        User currentUser = securityService.getCurrentUser();

        Transaction transaction = transactionRepository
                .findByIdAndUser(id, currentUser)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        transactionRepository.delete(transaction);
    }

    @Override
    public List<Transaction> searchByCategory(String category) {
        return transactionRepository.findByCategoryContainingIgnoreCase(category);
    }

    @Override
    public List<Transaction> searchByTransactionType(String transactionType) {
        return transactionRepository.findByTransactionTypeIgnoreCase(transactionType);
    }

    @Override
    public List<Transaction> searchByCategoryAndTransactionType(
            String category,
            String transactionType) {

        return transactionRepository
                .findByCategoryContainingIgnoreCaseAndTransactionTypeIgnoreCase(
                        category,
                        transactionType
                );
    }

    @Override
    public Page<Transaction> getTransactions(
            int page,
            int size,
            String sortBy,
            String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return transactionRepository.findAll(pageable);
    }

    @Override
    public List<Transaction> getTransactionsByDate(LocalDate date) {
        return transactionRepository.findByDate(date);
    }

    @Override
    public List<Transaction> getTransactionsByDateRange(
            LocalDate startDate,
            LocalDate endDate) {

        return transactionRepository.findByDateBetween(startDate, endDate);
    }

    @Override
    public List<Transaction> getTransactionsByAmountRange(
            BigDecimal minAmount,
            BigDecimal maxAmount) {

        return transactionRepository.findByAmountBetween(minAmount, maxAmount);
    }
}