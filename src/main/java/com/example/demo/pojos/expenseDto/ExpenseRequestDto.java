package com.example.demo.pojos.expenseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseRequestDto {
    @Min(1)
    private BigDecimal amount;
    @NotBlank(message = "Enter a description")
    private String description;

}
