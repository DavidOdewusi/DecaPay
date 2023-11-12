package com.example.demo.controller.auth;
import com.example.demo.pojos.requestDtos.ForgetPasswordRequest;
import com.example.demo.pojos.requestDtos.LoginRequestDto;
import com.example.demo.pojos.requestDtos.ResetPasswordRequest;
import com.example.demo.pojos.requestDtos.UserRequestDto;
import com.example.demo.pojos.responseDtos.LoginResponseDto;
import com.example.demo.pojos.responseDtos.TokenVerificationResponse;
import com.example.demo.pojos.responseDtos.UserResponseDto;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserAuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto requestDto) throws MessagingException {

        UserResponseDto returnValue = userService.createUser(requestDto);

        return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
    }

    @GetMapping("/verify-token/{token}")
    public TokenVerificationResponse verifyToken(@PathVariable("token") String token) {
       return userService.verifyToken(token);
    }


    @PostMapping("/signin")
    public ResponseEntity<LoginResponseDto> signIn(@RequestBody @Valid LoginRequestDto loginRequestDto){
        return userService.userLogin(loginRequestDto);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody @Valid ForgetPasswordRequest request){
        return new ResponseEntity<>(userService.forgotPasswordRequest(request), HttpStatus.OK);
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestBody @Valid ResetPasswordRequest request){
        return userService.resetPassword(request);
    }
}
