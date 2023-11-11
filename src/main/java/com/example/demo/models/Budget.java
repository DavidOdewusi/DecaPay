package com.example.demo.models;

import com.example.demo.enums.BudgetPeriod;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;



@Getter
@Setter
@Entity
@Table(name = "budget_tb")
public class Budget extends BaseEntity{

    private String title;
    private BigDecimal amount;
    private String description;

    @Enumerated(value = EnumType.STRING)
    private BudgetPeriod budgetPeriod;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Timestamp
    private LocalDate startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Timestamp
    private LocalDate endDate;

    @OneToMany(mappedBy = "budget", cascade = CascadeType.ALL)
    private List<LineItem> lineItems;

    @ManyToOne
    @JoinColumn(name = "user_tb_id")
    private User user;
}
