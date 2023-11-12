package com.example.demo.pojos.responseDtos;

import lombok.Data;

import java.math.BigDecimal;



@Data
public class LineItemRest {
    private Long lineItemId;
    private String category;
    private BigDecimal projectedAmount;
    private BigDecimal amountSpentSoFar;
    private BigDecimal percentageSpentSoFar;
}
