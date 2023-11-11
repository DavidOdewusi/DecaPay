package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@Entity
@Table(name = "expense_tb")
public class Expense extends BaseEntity{

    private BigDecimal amount;

    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "line_item_tb_id")
    private LineItem lineItem;

}
