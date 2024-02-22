package com.library.api.service.impl;

import com.library.api.dto.CategoryDto;
import com.library.api.models.Category;
import com.library.api.repositories.CategoryRepository;
import com.library.api.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    public CategoryServiceImpl(CategoryRepository repository){
        this.repository=repository;
    }
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = Category.builder()
                .id(categoryDto.getId())
                .name(categoryDto.getName())
                .build();
        Category saved = repository.save(category);
        return CategoryDto.CategoryDtoBuilder.fromCategory(saved);
    }
}
