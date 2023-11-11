package com.example.demo.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


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
