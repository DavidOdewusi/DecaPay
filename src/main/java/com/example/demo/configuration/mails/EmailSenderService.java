package com.example.demo.configuration.mails;


import com.example.demo.pojos.mailDto.MailDto;
import org.springframework.http.ResponseEntity;

public interface EmailSenderService {
    ResponseEntity<String> sendEmail(MailDto mailDto);

    void sendPasswordResetEmail(String name, String email, String link);
}
