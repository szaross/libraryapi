package com.library.api.service;

import com.library.api.dto.BookDto;
import com.library.api.dto.BookResponse;

public interface BookService {
    BookDto createBook(BookDto bookDto);

    BookDto getBookById(long id);

    BookResponse getAllBooksByAuthorId(int pageNo, int pageSize, long author_id);

    BookResponse getAllBooks(int pageNo, int pageSize);
}
