package com.bernardomecabo.financial_control_system.repo;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.bernardomecabo.financial_control_system.model.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction,Long>{
    List<Transaction> findByUserId(Long userId);

    @Query("SELECT SUM(CASE WHEN t.transactionType = 'receita' THEN t.value ELSE -t.value END) " +
           "FROM Transaction t WHERE t.user.userId = :userId")
    BigDecimal calculateBalance(Long userId);
}
