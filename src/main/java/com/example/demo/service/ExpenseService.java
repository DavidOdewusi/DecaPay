package com.example.demo.service;

import com.example.demo.models.Expense;
import com.example.demo.pojos.expenseDto.ExpenseRequestDto;
import com.example.demo.pojos.expenseDto.ExpenseResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface ExpenseService {
    ResponseEntity<ExpenseResponseDto> createExpense(ExpenseRequestDto expenseRequestDto, Long lineId);


    Boolean deleteExpense(Long id);

    ResponseEntity<Page<Expense>> getExpenses(Long lineId, Integer pageNo, Integer pageSize, String sortBy, boolean isAscending);

    ExpenseResponseDto updateExpense(ExpenseRequestDto expenseRequestDto, Long expenseId);
}
