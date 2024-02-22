package com.library.api.service.impl;

import com.library.api.dto.AuthorDto;
import com.library.api.exceptions.AuthorNotFoundException;
import com.library.api.models.Author;
import com.library.api.repositories.AuthorRepository;
import com.library.api.service.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository){
        this.authorRepository=authorRepository;
    }
    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = Author.builder()
                .name(authorDto.getName())
                .build();
        Author saved = authorRepository.save(author);

        return AuthorDto.AuthorDtoBuilder.fromAuthor(saved);
    }

    @Override
    public AuthorDto getAuthorById(long author_id) {
        Author author = authorRepository.findById(author_id).orElseThrow(() -> new AuthorNotFoundException("Author not found."));

        return AuthorDto.AuthorDtoBuilder.fromAuthor(author);
    }
}
