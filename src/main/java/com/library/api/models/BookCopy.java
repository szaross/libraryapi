package com.library.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookCopy {
    @OneToMany
    List<Loan> loans;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private Year year_published;
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

}
