package com.bernardomecabo.financial_control_system.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bernardomecabo.financial_control_system.model.Transaction;
import com.bernardomecabo.financial_control_system.repo.CategoryRepo;
import com.bernardomecabo.financial_control_system.service.TransactionService;

@Controller
@RequestMapping
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CategoryRepo categoryRepo;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/transactions/{userId}")
    public String listTransactions(@PathVariable Long userId, Model model) {
        BigDecimal balance = transactionService.getBalance(userId);
        List<Transaction> transactions = transactionService.getTransactionsByUserId(userId);
        model.addAttribute("balance", balance != null ? balance : BigDecimal.ZERO);
        model.addAttribute("transactions", transactions);
        return "transactions";
    }

    @GetMapping("/transactions/new-transaction")
    public String newTransactionForm(Model model) {
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("categories", categoryRepo.findByUserUserId(1L));
        return "new-transaction";
    }

    @PostMapping("/transactions/new-transaction")
    public String saveTransaction(Transaction transaction) {
        transactionService.saveTransaction(transaction);
        return "redirect:/transactions/1";
    }

    @GetMapping("/api/balance/{userId}")
    public BigDecimal getBalance(@PathVariable Long userId) {
        return transactionService.getBalance(userId);
    }

    @GetMapping("/api/transactions/{userId}")
    public List<Transaction> getTransactions(@PathVariable Long userId) {
        return transactionService.getTransactionsByUserId(userId);
    }
}
