package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;



@Getter
@Setter
@Entity
@Table(name = "line_item_tb")
public class LineItem extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "category_tb_id")
    private BudgetCategory budgetCategory;

    private BigDecimal projectedAmount = BigDecimal.ZERO;

    private BigDecimal totalAmountSpent = BigDecimal.ZERO;

    @OneToMany(mappedBy = "lineItem", cascade = CascadeType.ALL)
    private List<Expense> expenses;

    @ManyToOne
    @JoinColumn(name = "budget_tb_id")
    private Budget budget;
}
