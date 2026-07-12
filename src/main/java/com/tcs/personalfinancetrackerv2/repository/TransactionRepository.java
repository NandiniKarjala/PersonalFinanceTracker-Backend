package com.tcs.personalfinancetrackerv2.repository;

import com.tcs.personalfinancetrackerv2.entity.Transaction;
import com.tcs.personalfinancetrackerv2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByUser(User user);

    List<Transaction> findByUserAndDateBetween(User user,
                                               LocalDate startDate,
                                               LocalDate endDate);

    List<Transaction> findByUserAndCategory(User user,
                                            String category);
}