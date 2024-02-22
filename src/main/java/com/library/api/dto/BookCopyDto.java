package com.library.api.dto;

import com.library.api.models.BookCopy;
import lombok.Data;

import java.time.Year;

@Data
public class BookCopyDto {
    private long id;
    private long book_id;
    private Year year_published;
    private long publisher_id;

    public static class BookCopyDtoBuilder{
        public static BookCopyDto fromBookCopy(BookCopy bookCopy){
            BookCopyDto dto = new BookCopyDto();
            dto.setId(bookCopy.getId());
            dto.setYear_published(bookCopy.getYear_published());
            dto.setBook_id(bookCopy.getBook().getId());
            dto.setPublisher_id(bookCopy.getPublisher().getId());

            return dto;
        }
    }
}
