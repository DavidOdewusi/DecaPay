package com.example.demo.utils;

import org.springframework.stereotype.Service;

@Service
public class PasswordUtils {

    public boolean validatePassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

}
