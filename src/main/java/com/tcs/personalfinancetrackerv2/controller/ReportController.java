package com.tcs.personalfinancetrackerv2.controller;

import com.tcs.personalfinancetrackerv2.dto.ReportResponse;
import com.tcs.personalfinancetrackerv2.entity.Transaction;
import com.tcs.personalfinancetrackerv2.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final TransactionService transactionService;

    public ReportController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/monthly")
    public ReportResponse getMonthlyReport() {

        List<Transaction> transactions = transactionService.getAllTransactions();

        BigDecimal income = BigDecimal.ZERO;
        BigDecimal expense = BigDecimal.ZERO;

        for (Transaction transaction : transactions) {

            if ("INCOME".equalsIgnoreCase(transaction.getTransactionType())) {
                income = income.add(transaction.getAmount());
            } else if ("EXPENSE".equalsIgnoreCase(transaction.getTransactionType())) {
                expense = expense.add(transaction.getAmount());
            }
        }

        BigDecimal balance = income.subtract(expense);

        return new ReportResponse(
                income,
                expense,
                balance
        );
    }
}