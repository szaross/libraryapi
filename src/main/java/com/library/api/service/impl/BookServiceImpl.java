package com.library.api.service.impl;

import com.library.api.dto.BookDto;
import com.library.api.dto.BookResponse;
import com.library.api.exceptions.AuthorNotFoundException;
import com.library.api.exceptions.BookNotFoundException;
import com.library.api.models.Author;
import com.library.api.models.Book;
import com.library.api.models.Category;
import com.library.api.repositories.AuthorRepository;
import com.library.api.repositories.BookRepository;
import com.library.api.repositories.CategoryRepository;
import com.library.api.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, CategoryRepository categoryRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Category category = categoryRepository.findById(bookDto.getCategory_id()).orElseThrow(() -> new RuntimeException());
        Author author = authorRepository.findById(bookDto.getAuthor_id()).orElseThrow(() -> new AuthorNotFoundException("Author not found."));
        Book new_book = Book.builder()
                .title(bookDto.getTitle())
                .author(author)
                .category(category)
                .build();
        Book saved = bookRepository.save(new_book);
        System.out.println(saved);
        return BookDto.BookDtoBuilder.fromBook(saved);
    }

    @Override
    public BookDto getBookById(long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found."));
        return BookDto.BookDtoBuilder.fromBook(book);
    }

    @Override
    public BookResponse getAllBooksByAuthorId(int pageNo, int pageSize, long author_id) {
        Author author = authorRepository.findById(author_id).orElseThrow(() -> new AuthorNotFoundException("Author not found."));
        Pageable pageRequest = PageRequest.of(pageNo, pageSize);

        Page<Book> page = bookRepository.findBooksByAuthor(author, pageRequest);
        List<BookDto> bookDtos = page
                .getContent()
                .stream()
                .map(BookDto.BookDtoBuilder::fromBook)
                .toList();

        return BookResponse.builder()
                .totalPages(page.getTotalPages())
                .books(bookDtos)
                .pageNo(page.getNumber())
                .pageSize(page.getSize())
                .last(page.isLast())
                .build();
    }

    @Override
    public BookResponse getAllBooks(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Book> page = bookRepository.findAll(pageable);

        List<BookDto> allBooks = page
                .getContent()
                .stream()
                .map(BookDto.BookDtoBuilder::fromBook)
                .toList();

        return BookResponse.builder()
                .totalPages(page.getTotalPages())
                .books(allBooks)
                .pageNo(page.getNumber())
                .pageSize(page.getSize())
                .last(page.isLast())
                .build();
    }
}
