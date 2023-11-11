package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@Table(name = "category_tb")
public class BudgetCategory extends BaseEntity{
    private String name;
    private Boolean isDeleted;

    @ManyToOne()
    @JoinColumn(name = "user_tb_id")
    private User user;
}
