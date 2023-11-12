package com.example.demo.exceptions;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;


@AllArgsConstructor
public class ResourceNotFoundException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public ResourceNotFoundException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }
}
