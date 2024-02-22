package com.library.api.service;

import com.library.api.dto.CategoryDto;
import com.library.api.models.Category;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
}
