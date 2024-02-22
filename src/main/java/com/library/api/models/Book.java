package com.library.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

}
