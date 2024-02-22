package com.library.api.service;

import com.library.api.dto.PublisherDto;

public interface PublisherService {
    PublisherDto createPublisher(PublisherDto publisherDto);

    PublisherDto getPublisherById(long id);

}
