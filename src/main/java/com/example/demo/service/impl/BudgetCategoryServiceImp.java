package com.example.demo.service.impl;


import com.example.demo.exceptions.AuthenticationException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.BudgetCategory;
import com.example.demo.models.User;
import com.example.demo.pojos.requestDtos.BudgetCategoryRequest;
import com.example.demo.pojos.responseDtos.BudgetCategoryResponse;
import com.example.demo.repository.BudgetCategoryRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BudgetCategoryService;
import com.example.demo.service.UserService;
import com.example.demo.utils.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class BudgetCategoryServiceImp implements BudgetCategoryService {

    private final BudgetCategoryRepository budgetCategoryRepository;
    private  final UserRepository userRepository;
    private final UserUtil userUtil;
    private final UserService userService;

    @Override
    public BudgetCategoryResponse createBudgetCategory(BudgetCategoryRequest budgetCategoryRequest) {

        String email= userUtil.getAuthenticatedUserEmail();

        User user= userRepository.findByEmail(email)
                .orElseThrow(()-> new EntityNotFoundException("User not found"));

        Optional<BudgetCategory> categoryOptional = budgetCategoryRepository
                .findByName(budgetCategoryRequest.getName());

        BudgetCategory budgetCategory = new BudgetCategory();

        if (categoryOptional.isEmpty()) {
            budgetCategory.setName(budgetCategoryRequest.getName());
            budgetCategory.setUser(user);
        } else {
            budgetCategory = categoryOptional.get();
        }

        budgetCategory.setIsDeleted(false);
        budgetCategory=budgetCategoryRepository.save(budgetCategory);


        return BudgetCategoryResponse.mapFrom(budgetCategory);
    }



    @Override
    public BudgetCategoryResponse updateBudgetCategory(Long budgetCategoryId, BudgetCategoryRequest budgetCategoryRequest)
    {

        String email = userUtil
                .getAuthenticatedUserEmail();

        userService.verifyUserExists(email);

        BudgetCategory budgetCategory =
                budgetCategoryRepository
                        .findById(budgetCategoryId)
                        .orElseThrow(()-> new
                                EntityNotFoundException("Budget not found"));

        BeanUtils.copyProperties(budgetCategoryRequest, budgetCategory);

        budgetCategoryRepository.save(budgetCategory);

        return BudgetCategoryResponse.mapFrom(budgetCategory);

    }

    @Override
    public BudgetCategoryResponse getBudgetCategory(Long budgetCategoryId) {
        User user = userService.getUserByEmail(userUtil.getAuthenticatedUserEmail());
        BudgetCategory budgetCategory = budgetCategoryRepository.findById(budgetCategoryId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        HttpStatus.BAD_REQUEST, "Specified budget category not found"));
        if (!(budgetCategory.getUser().getId().equals(user.getId()))){
            throw new AuthenticationException("Action Not Authorized");
        }
        return BudgetCategoryResponse.mapFrom(budgetCategory);
    }

    @Override
    public List<BudgetCategoryResponse> getBudgetCategories() {
        User user = userService.getUserByEmail(userUtil.getAuthenticatedUserEmail());
        List<BudgetCategory> budgetCategoryList = budgetCategoryRepository.findByUser(user);

        budgetCategoryList = budgetCategoryList
                .stream()
                .filter(cat -> !cat.getIsDeleted())
                .collect(Collectors.toList());

        return BudgetCategoryResponse.mapFromList(budgetCategoryList);
    }

    @Override
    public void deleteBudgetCategory(Long budgetCategoryId) {

        User user = userService.getUserByEmail(userUtil.getAuthenticatedUserEmail());

        BudgetCategory budgetCategory = budgetCategoryRepository.findById(budgetCategoryId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        HttpStatus.BAD_REQUEST, "Specified budget category not found"));

        if (!(budgetCategory.getUser().getId().equals(user.getId()))){
            throw new AuthenticationException("Action Not Authorized");
        }

        budgetCategory.setIsDeleted(true);
        budgetCategoryRepository.save(budgetCategory);
    }
}
