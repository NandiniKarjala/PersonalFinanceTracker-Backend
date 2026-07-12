package com.tcs.personalfinancetrackerv2.service.impl;

import com.tcs.personalfinancetrackerv2.entity.Transaction;
import com.tcs.personalfinancetrackerv2.repository.TransactionRepository;
import com.tcs.personalfinancetrackerv2.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }
    @Override
    public Transaction updateTransaction(Long id, Transaction transaction) {

        Transaction existingTransaction =
                transactionRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Transaction not found"));

        existingTransaction.setAmount(transaction.getAmount());
        existingTransaction.setCategory(transaction.getCategory());
        existingTransaction.setTransactionType(transaction.getTransactionType());
        existingTransaction.setDescription(transaction.getDescription());
        existingTransaction.setDate(transaction.getDate());
        existingTransaction.setUser(transaction.getUser());

        return transactionRepository.save(existingTransaction);

    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}