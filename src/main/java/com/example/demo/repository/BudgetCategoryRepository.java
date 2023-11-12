package com.example.demo.repository;

import com.example.demo.models.BudgetCategory;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BudgetCategoryRepository extends JpaRepository<BudgetCategory,Long> {
    List<BudgetCategory> findByUser(User user);
    Optional<BudgetCategory> findByName(String name);
}
