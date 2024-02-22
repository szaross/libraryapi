package com.library.api.service.impl;

import com.library.api.dto.BookCopyDto;
import com.library.api.exceptions.AuthorNotFoundException;
import com.library.api.exceptions.BookNotFoundException;
import com.library.api.models.Book;
import com.library.api.models.BookCopy;
import com.library.api.models.Publisher;
import com.library.api.repositories.BookCopyRepository;
import com.library.api.repositories.BookRepository;
import com.library.api.repositories.PublisherRepository;
import com.library.api.service.BookCopyService;
import org.springframework.stereotype.Service;

@Service
public class BookCopyServiceImpl implements BookCopyService {
    private final BookCopyRepository bookCopyRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BookCopyServiceImpl(BookCopyRepository bookCopyRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.bookCopyRepository = bookCopyRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public BookCopyDto createBookCopy(BookCopyDto bookCopyDto) {
        Publisher publisher = publisherRepository.findById(bookCopyDto.getPublisher_id()).orElseThrow(() -> new AuthorNotFoundException("Publisher not found."));
        Book book = bookRepository.findById(bookCopyDto.getBook_id()).orElseThrow(() -> new BookNotFoundException("Book not found."));
        BookCopy new_copy = BookCopy.builder()
                .book(book)
                .publisher(publisher)
                .year_published(bookCopyDto.getYear_published())
                .build();
        BookCopy saved = bookCopyRepository.save(new_copy);
        return BookCopyDto.BookCopyDtoBuilder.fromBookCopy(saved);
    }

    @Override
    public BookCopyDto getBookCopyById(long id) {
        BookCopy bookCopy = bookCopyRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException("Book Copy not found."));
        return BookCopyDto.BookCopyDtoBuilder.fromBookCopy(bookCopy);
    }
}
