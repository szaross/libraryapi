package com.library.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BookResponse {
    private List<BookDto> books;
    private int pageNo;
    private int pageSize;
    private int totalPages;
    private boolean last;
}
