package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;



@Getter
@Setter
@ToString
@Entity
@Table(name = "user_tb")
public class User extends BaseEntity {

    @Column(unique = true)
    private String userId;
    private String firstName;
    private String lastName;
    private boolean isVerified;
    private String imagePath;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phoneNumber;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BudgetCategory> categories;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Budget> budgets;
}
