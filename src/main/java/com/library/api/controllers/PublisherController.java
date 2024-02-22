package com.library.api.controllers;

import com.library.api.dto.PublisherDto;
import com.library.api.service.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/publisher/")
public class PublisherController {
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<PublisherDto> getPublisherById(@PathVariable(name = "id") long id) {
        PublisherDto response = publisherService.getPublisherById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/create")
    public ResponseEntity<PublisherDto> createPublisher(@RequestBody PublisherDto publisherDto) {
        PublisherDto response = publisherService.createPublisher(publisherDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
