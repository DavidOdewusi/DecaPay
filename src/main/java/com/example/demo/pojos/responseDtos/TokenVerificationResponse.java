package com.example.demo.pojos.responseDtos;

import com.example.demo.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class TokenVerificationResponse {
    private String token;
    private Status status;
    private String email;
}
