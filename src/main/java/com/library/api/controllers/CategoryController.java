package com.library.api.controllers;

import com.library.api.dto.CategoryDto;
import com.library.api.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category/")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }

    @PutMapping("/create")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        System.out.println(categoryDto);
        CategoryDto response = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
