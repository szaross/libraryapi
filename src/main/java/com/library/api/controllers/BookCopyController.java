package com.library.api.controllers;

import com.library.api.dto.BookCopyDto;
import com.library.api.service.BookCopyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bcopy/")
public class BookCopyController {
    private final BookCopyService bookCopyService;

    public BookCopyController(BookCopyService bookCopyService) {
        this.bookCopyService = bookCopyService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookCopyDto> getBookCopyById(@PathVariable(name = "id") long id) {
        BookCopyDto response = bookCopyService.getBookCopyById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/create")
    public ResponseEntity<BookCopyDto> createBookCopy(@RequestBody BookCopyDto bookCopyDto) {
        BookCopyDto response = bookCopyService.createBookCopy(bookCopyDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
