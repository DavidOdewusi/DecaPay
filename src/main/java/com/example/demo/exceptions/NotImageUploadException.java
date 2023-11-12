package com.example.demo.exceptions;

public class NotImageUploadException extends RuntimeException{

    public NotImageUploadException(String message) {
        super(message);
    }
}
