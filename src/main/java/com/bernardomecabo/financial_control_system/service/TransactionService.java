package com.bernardomecabo.financial_control_system.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bernardomecabo.financial_control_system.model.Transaction;
import com.bernardomecabo.financial_control_system.repo.TransactionRepo;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepo transactionRepo;

    public BigDecimal getBalance(Long userId){
        return transactionRepo.calculateBalance(userId);
    }

    public List<Transaction> getTransactionsByUserId(Long userId){
        return transactionRepo.findByUserId(userId);
    }

    public void saveTransaction(Transaction transaction){
        transactionRepo.save(transaction);
    }
}
