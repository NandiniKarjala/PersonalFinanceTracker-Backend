package com.tcs.personalfinancetrackerv2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponse {

    private Long id;

    private Long userId;

    private String username;

    private BigDecimal amount;

    private String category;

    private String transactionType;

    private String description;

    private LocalDate date;

}