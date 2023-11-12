package com.example.demo.service.impl;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Budget;
import com.example.demo.models.BudgetCategory;
import com.example.demo.models.LineItem;
import com.example.demo.pojos.requestDtos.LineItemRequestDto;
import com.example.demo.pojos.responseDtos.LineItemResponseDto;
import com.example.demo.repository.BudgetCategoryRepository;
import com.example.demo.repository.BudgetRepository;
import com.example.demo.repository.LineItemRepository;
import com.example.demo.service.LineItemServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LineItemServicesImpl implements LineItemServices {

    private final LineItemRepository lineItemRepository;
    private final BudgetRepository budgetRepository;
    private final BudgetCategoryRepository budgetCategoryRepository;



    public LineItemResponseDto createLineItem (LineItemRequestDto lineItemRequestDto) {
        Budget budget = budgetRepository.findById(lineItemRequestDto.getBudgetId()).orElseThrow( ()
                -> new ResourceNotFoundException("cannot create line item", HttpStatus.FORBIDDEN, "please select a budget"));
        BudgetCategory budgetCategory = budgetCategoryRepository.findById(lineItemRequestDto.getBudgetCategoryId()).orElseThrow(()
                -> new ResourceNotFoundException("line item cannot be created", HttpStatus.FORBIDDEN, "please select a budget category"));
        LineItem newLineItem = new LineItem();

        newLineItem.setBudgetCategory(budgetCategory);
        newLineItem.setProjectedAmount(lineItemRequestDto.getProjectedAmount());
        newLineItem.setBudget(budget);

        newLineItem =  lineItemRepository.save(newLineItem);

        LineItemResponseDto lineItemResponseDto = new LineItemResponseDto();
        lineItemResponseDto.setLineItemId(newLineItem.getId());
        lineItemResponseDto.setBudgetAmount(newLineItem.getBudget().getAmount());
        lineItemResponseDto.setBudgetCategoryName(newLineItem.getBudgetCategory().getName());
        lineItemResponseDto.setProjectedAmount(newLineItem.getProjectedAmount());

        return lineItemResponseDto;
    }
    

    @Override
    public ResponseEntity<LineItemResponseDto> updateLineItem(LineItemRequestDto lineItemRequestDto, Long lineItemId) {

        LineItemResponseDto lineItemResponseDto = null;

        LineItem lineItem = lineItemRepository.findById(lineItemId)
                .orElseThrow(() -> new ResourceNotFoundException("Line item does not exist", HttpStatus.NOT_FOUND, "Please select a valid line item"));
        lineItem.setProjectedAmount(lineItemRequestDto.getProjectedAmount());
        lineItem = lineItemRepository.save(lineItem);


        lineItemResponseDto = LineItemResponseDto.builder()
                .lineItemId(lineItem.getId())
                .budgetAmount(lineItem.getBudget().getAmount())
                .budgetCategoryName(lineItem.getBudgetCategory().getName())
                .projectedAmount(lineItem.getProjectedAmount())
                .totalAmountSpent(lineItem.getTotalAmountSpent())
                .build();

        return new ResponseEntity<>(lineItemResponseDto, HttpStatus.OK);
    }
    

    @Override
    public List<LineItemResponseDto> getLineItems() {
        List<LineItem> lineItems = lineItemRepository.findAll();
        List<LineItemResponseDto> lineItemResponseDtos = new ArrayList<>();
        for (LineItem lineItem : lineItems) {
            LineItemResponseDto lineItemResponseDto = new LineItemResponseDto();
            lineItemResponseDto.setLineItemId(lineItem.getId());
            lineItemResponseDto.setBudgetAmount(lineItem.getBudget().getAmount());
            lineItemResponseDto.setBudgetCategoryName(lineItem.getBudgetCategory().getName());
            lineItemResponseDto.setProjectedAmount(lineItem.getProjectedAmount());
            lineItemResponseDtos.add(lineItemResponseDto);
        }
        return lineItemResponseDtos;
     }   


    public Boolean deleteLineItem(Long id) {

        LineItem lineItem = lineItemRepository.findById(id).orElseThrow(()
                ->new ResourceNotFoundException("line item  not found", HttpStatus.BAD_REQUEST,"Please select a valid line item"));
        lineItemRepository.delete(lineItem);
        return true;

    }



}
