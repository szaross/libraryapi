package com.library.api.controllers;

import com.library.api.dto.AuthorDto;
import com.library.api.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/author/")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PutMapping("/create")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto){
        AuthorDto response = authorService.createAuthor(authorDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable(name = "id") long author_id){
        AuthorDto response = authorService.getAuthorById(author_id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
