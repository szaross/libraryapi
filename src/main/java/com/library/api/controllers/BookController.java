package com.library.api.controllers;

import com.library.api.dto.BookDto;
import com.library.api.dto.BookResponse;
import com.library.api.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/book/")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService=bookService;
    }

    @PutMapping("/create")
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto){
        BookDto response = bookService.createBook(bookDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable(name = "id") long bookid){
        BookDto response = bookService.getBookById(bookid);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<BookResponse> getAllBooks(@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
                                                    @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize){
        BookResponse bookResponse = bookService.getAllBooks(pageNo, pageSize);

        return new ResponseEntity<>(bookResponse,HttpStatus.OK);
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<BookResponse> getAllBooksByAuthor(@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
                                                            @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize,
                                                            @PathVariable(name = "id") long author_id){
        BookResponse bookResponse = bookService.getAllBooksByAuthorId(pageNo, pageSize, author_id);

        return new ResponseEntity<>(bookResponse,HttpStatus.OK);
    }

}
