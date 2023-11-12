package com.example.demo.service;

import com.example.demo.pojos.requestDtos.BudgetDto;
import com.example.demo.pojos.requestDtos.CreateBudgetRequest;
import com.example.demo.pojos.responseDtos.BudgetDtoResponse;
import com.example.demo.pojos.responseDtos.BudgetViewModel;
import com.example.demo.pojos.responseDtos.CreateBudgetResponse;

import java.util.List;

public interface BudgetService {

    List<BudgetViewModel> getBudgets(int page, int limit);
    CreateBudgetResponse createBudget(CreateBudgetRequest budgetRequest);

    BudgetViewModel fetchBudgetById(Long budgetId);
    void deleteBudget(Long budgetId);

    BudgetDtoResponse updateBudget(BudgetDto budgetDto, Long budgetId);
}