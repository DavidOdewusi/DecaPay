package com.example.demo.pojos.responseDtos;

import com.example.demo.enums.BudgetPeriod;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Data
public class BudgetViewModel {
    private Long budgetId;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private BudgetPeriod budgetPeriod;
    private String description;
    private int totalBudgets;
    private BigDecimal amount;
    private BigDecimal totalAmountSpent;
    private BigDecimal percentage;
    private List<LineItemRest> lineItemRests;
}
