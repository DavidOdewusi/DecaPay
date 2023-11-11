package com.example.demo.models;


import com.example.demo.enums.Status;
import com.example.demo.enums.VerificationType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Table(name = "token_tb")
@Entity
public class Token extends BaseEntity {

    private String token;

    @Enumerated(value = EnumType.STRING)
    private VerificationType verificationType;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @OneToOne
    @JoinColumn(name = "user_tb_id")
    private User user;
}
