package com.tcs.personalfinancetrackerv2.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardResponse {

    private BigDecimal totalIncome;

    private BigDecimal totalExpense;

    private BigDecimal balance;

    // New Fields
    private Long totalTransactions;

    private Long incomeTransactions;

    private Long expenseTransactions;

}