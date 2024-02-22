package com.library.api.dto;

import com.library.api.models.Publisher;
import lombok.Data;

@Data
public class PublisherDto {
    private long id;
    private String name;

    public static class PublisherDtoBuilder{
        public static PublisherDto fromPublisher(Publisher publisher){
            PublisherDto dto = new PublisherDto();
            dto.setId(publisher.getId());
            dto.setName(publisher.getName());
            return dto;
        }
    }
}
