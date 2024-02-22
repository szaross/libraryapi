package com.library.api.service.impl;

import com.library.api.dto.PublisherDto;
import com.library.api.exceptions.AuthorNotFoundException;
import com.library.api.models.Publisher;
import com.library.api.repositories.PublisherRepository;
import com.library.api.service.PublisherService;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public PublisherDto createPublisher(PublisherDto publisherDto) {
        Publisher new_publisher = Publisher.builder()
                .name(publisherDto.getName())
                .build();
        Publisher saved = publisherRepository.save(new_publisher);
        return PublisherDto.PublisherDtoBuilder.fromPublisher(saved);
    }

    @Override
    public PublisherDto getPublisherById(long id) {
        Publisher publisher = publisherRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException("Publisher not found"));
        return PublisherDto.PublisherDtoBuilder.fromPublisher(publisher);
    }
}
