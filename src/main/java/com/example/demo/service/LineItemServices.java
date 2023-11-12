package com.example.demo.service;

import com.example.demo.pojos.requestDtos.LineItemRequestDto;
import com.example.demo.pojos.responseDtos.LineItemResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface LineItemServices {

    LineItemResponseDto createLineItem(LineItemRequestDto lineItemRequestDto);

    ResponseEntity<LineItemResponseDto> updateLineItem(LineItemRequestDto lineItemRequestDto, Long lineItemId);

    List<LineItemResponseDto> getLineItems();

    Boolean deleteLineItem(Long id);

}