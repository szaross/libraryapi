package com.library.api.dto;

import com.library.api.models.Book;
import lombok.Data;

@Data
public class BookDto {
    private long id;
    private String title;
    private long author_id;
    private long category_id;

    public static class BookDtoBuilder{
        public static BookDto fromBook(Book book){
            BookDto dto = new BookDto();
            dto.setTitle(book.getTitle());
            dto.setId(book.getId());
            dto.setAuthor_id(book.getAuthor().getId());
            dto.setCategory_id(book.getCategory().getId());
            return dto;
        }
    }
}
