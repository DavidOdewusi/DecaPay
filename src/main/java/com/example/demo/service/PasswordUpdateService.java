package com.example.demo.service;


import com.example.demo.pojos.requestDtos.PasswordUpdateRequest;
import org.springframework.stereotype.Service;

@Service
public interface PasswordUpdateService {
    void updatePassword(PasswordUpdateRequest passwordUpdateRequest);
}
