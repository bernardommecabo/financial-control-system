package com.bernardomecabo.financial_control_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bernardomecabo.financial_control_system.model.User;

public interface UserRepo extends JpaRepository<User,Long>{
    User findByUsername(String username);
}
