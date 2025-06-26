package com.bernardomecabo.financial_control_system.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bernardomecabo.financial_control_system.model.Category;

public interface CategoryRepo extends JpaRepository<Category,Long>{
    List<Category> findByUserId(Long userId);
}
