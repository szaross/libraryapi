package com.library.api.dto;

import com.library.api.models.Category;
import lombok.Data;

@Data
public class CategoryDto {
    private long id;
    private String name;
    public static class CategoryDtoBuilder{
        public static CategoryDto fromCategory(Category category){
            CategoryDto dto = new CategoryDto();
            dto.setId(category.getId());
            dto.setName(category.getName());
            return dto;
        }
    }
}


