package com.tcs.personalfinancetrackerv2.service.impl;

import com.tcs.personalfinancetrackerv2.dto.ReportResponse;
import com.tcs.personalfinancetrackerv2.entity.Transaction;
import com.tcs.personalfinancetrackerv2.entity.User;
import com.tcs.personalfinancetrackerv2.repository.TransactionRepository;
import com.tcs.personalfinancetrackerv2.security.SecurityService;
import com.tcs.personalfinancetrackerv2.service.ReportService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final TransactionRepository transactionRepository;
    private final SecurityService securityService;

    public ReportServiceImpl(
            TransactionRepository transactionRepository,
            SecurityService securityService) {

        this.transactionRepository = transactionRepository;
        this.securityService = securityService;
    }

    @Override
    public ReportResponse getMonthlyReport() {

        User currentUser = securityService.getCurrentUser();

        List<Transaction> transactions =
                transactionRepository.findByUser(currentUser);

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