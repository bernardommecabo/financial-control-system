package com.bernardomecabo.financial_control_system.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bernardomecabo.financial_control_system.model.Transaction;
import com.bernardomecabo.financial_control_system.service.TransactionService;

@RestController
@RequestMapping("/api/financial")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/balance/{userId}")
    public BigDecimal getBalance(Long userId){
        return transactionService.getBalance(userId);
    }

    @GetMapping("/transactions/{userId}")
    public List<Transaction>  geTransactions(Long userId){
        return transactionService.getTransactionsByUserId(userId);
    }
}
