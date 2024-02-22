package com.library.api.service;

import com.library.api.dto.AuthorDto;

public interface AuthorService {
    AuthorDto createAuthor(AuthorDto authorDto);
    AuthorDto getAuthorById(long author_id);
}
