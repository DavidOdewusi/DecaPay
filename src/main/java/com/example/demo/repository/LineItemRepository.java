package com.example.demo.repository;


import com.example.demo.models.Budget;
import com.example.demo.models.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LineItemRepository extends JpaRepository<LineItem, Long> {
    List<LineItem> findAllByBudget(Budget budget);

}