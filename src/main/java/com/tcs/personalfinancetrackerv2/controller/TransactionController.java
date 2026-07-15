package com.tcs.personalfinancetrackerv2.controller;

import com.tcs.personalfinancetrackerv2.entity.Transaction;
import com.tcs.personalfinancetrackerv2.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public Transaction addTransaction(@Valid @RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Optional<Transaction> getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }

    @PutMapping("/{id}")
    public Transaction updateTransaction(@PathVariable Long id,
                                         @Valid @RequestBody Transaction transaction) {
        return transactionService.updateTransaction(id, transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {

        transactionService.deleteTransaction(id);

    }

    // ==========================
    // SEARCH
    // ==========================

    @GetMapping("/search/category")
    public List<Transaction> searchByCategory(@RequestParam String category) {
        return transactionService.searchByCategory(category);
    }

    @GetMapping("/search/type")
    public List<Transaction> searchByTransactionType(
            @RequestParam String transactionType) {

        return transactionService.searchByTransactionType(transactionType);
    }

    @GetMapping("/search")
    public List<Transaction> searchByCategoryAndTransactionType(
            @RequestParam String category,
            @RequestParam String transactionType) {

        return transactionService.searchByCategoryAndTransactionType(
                category,
                transactionType
        );
    }

    // ==========================
    // PAGINATION & SORTING
    // ==========================

    @GetMapping("/page")
    public Page<Transaction> getTransactions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "date") String sortBy,
            @RequestParam(defaultValue = "desc") String direction) {

        return transactionService.getTransactions(
                page,
                size,
                sortBy,
                direction
        );
    }

    // ==========================
    // ADVANCED FILTERS
    // ==========================

    @GetMapping("/filter/date")
    public List<Transaction> getTransactionsByDate(
            @RequestParam LocalDate date) {

        return transactionService.getTransactionsByDate(date);
    }

    @GetMapping("/filter/date-range")
    public List<Transaction> getTransactionsByDateRange(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {

        return transactionService.getTransactionsByDateRange(
                startDate,
                endDate
        );
    }

    @GetMapping("/filter/amount")
    public List<Transaction> getTransactionsByAmountRange(
            @RequestParam BigDecimal minAmount,
            @RequestParam BigDecimal maxAmount) {

        return transactionService.getTransactionsByAmountRange(
                minAmount,
                maxAmount
        );
    }
}