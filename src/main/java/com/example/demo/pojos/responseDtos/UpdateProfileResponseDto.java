package com.example.demo.pojos.responseDtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateProfileResponseDto {
    private String imageUrl;
    private String error;
}
