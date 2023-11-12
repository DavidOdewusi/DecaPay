package com.example.demo.controller;

import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.pojos.requestDtos.UserUpdateRequest;
import com.example.demo.pojos.responseDtos.LoginResponseDto;
import com.example.demo.pojos.responseDtos.UpdateProfileResponseDto;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequiredArgsConstructor@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;
    @PutMapping("/edit")
    public ResponseEntity<LoginResponseDto> editUser(@Valid @RequestBody UserUpdateRequest userUpdateRequest){
        return userService.editUser(userUpdateRequest);
    }

    @PostMapping(value = "/upload-profile-picture" , consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<UpdateProfileResponseDto> uploadProfilePic(@RequestPart(name = "file") MultipartFile image) throws IOException, UserNotFoundException{
        System.out.println("i am inside the controller");
        return userService.uploadProfilePicture(image);
    }
}
