package com.library.api.dto;

import com.library.api.models.Author;
import lombok.Data;

@Data
public class AuthorDto {
    private long id;
    private String name;
    public static class AuthorDtoBuilder{
        public static AuthorDto fromAuthor(Author author){
            AuthorDto dto = new AuthorDto();
            dto.setName(author.getName());
            dto.setId(author.getId());
            return dto;
        }
    }
}
