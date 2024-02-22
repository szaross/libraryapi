package com.library.api.repositories;

import com.library.api.models.Author;
import com.library.api.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findBooksByAuthor(Author author, Pageable pageable);
}
