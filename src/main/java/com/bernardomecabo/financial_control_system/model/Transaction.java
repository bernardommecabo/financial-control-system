package com.bernardomecabo.financial_control_system.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transacoes")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transacao_id")
    private long transactionId;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Category category;

    @Column(name = "valor", nullable = false)
    private BigDecimal value;

    @Column(name = "tipo_transacao", nullable = false)
    private String transactionType;

    private String transactionDescription;

    @Column(name = "data_transacao", nullable = false)
    private LocalDate transactionDate;

    @Column(name = "criado_em",nullable = false)
    private LocalDateTime transactionCreationDate;

    public Transaction(){}

    public Transaction(User user, Category category, BigDecimal value, String transactionType, String transactionDescription, LocalDate transactionDate){
        this.user = user;
        this.category = category;
        this.value = value;
        this.transactionType = transactionType;
        this.transactionDescription = transactionDescription;
        this.transactionDate = transactionDate;
        this.transactionCreationDate = LocalDateTime.now();
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public LocalDateTime getTransactionCreationDate() {
        return transactionCreationDate;
    }

    public void setTransactionCreationDate(LocalDateTime transactionCreationDate) {
        this.transactionCreationDate = transactionCreationDate;
    }
}
