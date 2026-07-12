package com.tcs.personalfinancetrackerv2.service;

import com.tcs.personalfinancetrackerv2.entity.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {

    Transaction saveTransaction(Transaction transaction);

    List<Transaction> getAllTransactions();

    Optional<Transaction> getTransactionById(Long id);

    Transaction updateTransaction(Long id, Transaction transaction);

    void deleteTransaction(Long id);

}