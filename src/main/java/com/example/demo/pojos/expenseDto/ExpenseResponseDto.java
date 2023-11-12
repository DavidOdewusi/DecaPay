package com.example.demo.pojos.expenseDto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ExpenseResponseDto {
    private BigDecimal amount;
    private String description;
    private LocalDateTime createdAt;

}
