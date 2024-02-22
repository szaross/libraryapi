package com.library.api.service;

import com.library.api.dto.BookCopyDto;

public interface BookCopyService {
    BookCopyDto createBookCopy(BookCopyDto bookCopyDto);

    BookCopyDto getBookCopyById(long id);
}
