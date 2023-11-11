package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
